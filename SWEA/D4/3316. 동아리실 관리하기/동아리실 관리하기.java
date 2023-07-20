import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


class Solution {

  static final int DIVIDER = 1_000_000_007;
  static int days, answer;
  static char[] masters;
  static int[][] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int tc = Integer.parseInt(st.nextToken());

    for (int i = 1; i <= tc; i++) {
      st = new StringTokenizer(br.readLine());
      masters = st.nextToken().toCharArray();
      days = masters.length;

      answer = 0;
      dp = new int[days][16];
      solve();
      bw.write("#" + i + " " + answer + "\n");
    }
    bw.flush();
    bw.close();
  }

  private static void solve() {
    for (int day = 0; day < days; day++) {
      int todayMaster = 1 << (masters[day] - 'A');

      // 모든 경우(조합)은 최소 1명의 팀원이 있어야하므로 0을 제외한다.
      for (int case1 = 1; case1 < 16; case1++) {
        if (day == 0) {
          // master를 포함하고, A를 포함하는 경우
          if (includeMaster(case1, todayMaster) && includeA(case1)) {
            dp[day][case1] = 1;
          }
        } else {
          // 둘째날 이후
          // 전날, 이 경우(조합)로 1이상의 경우의 수가 있을 때
          if (dp[day - 1][case1] > 0) {
            for (int case2 = 1; case2 < 16; case2++) {
              // 전날의 동아리원이 한명이라도 있어야하고, 오늘의 master를 포함하는 경우
              if (todayIncludeAnyoneFromYesterday(case1, case2)
                  && includeMaster(case2, todayMaster)) {
                // 다른 case1과 case2의 조합에 대한 경우의 수가 dp[day][case2]에 반영되어있으므로, 계속 누적해서 더한다.
                dp[day][case2] = (
                    dp[day][case2] + dp[day - 1][case1]
                ) % DIVIDER;
              }
            }
          }
        }
      }
    }

    // 모든 경우의 수를 고려하였으므로, 마지막날의 경우의 수 1~15에 각각의 case에 대한 경우의 수가 누적되어있으므로, 그 총합을 구한다.
    for (int i = 1; i < 16; i++) {
      answer = (answer + dp[days - 1][i]) % DIVIDER;
    }
  }

  private static boolean includeMaster(int nowCase, int master) {
    return (nowCase & master) != 0;
  }

  private static boolean includeA(int nowCase) {
    return (nowCase & 1) != 0;
  }

  private static boolean todayIncludeAnyoneFromYesterday(int todayCase, int yesterdayCase) {
    return (todayCase & yesterdayCase) != 0;
  }
}