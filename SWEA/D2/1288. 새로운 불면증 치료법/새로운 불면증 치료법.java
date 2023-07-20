import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


class Solution {

  static final int MAX = 1023;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int tc = Integer.parseInt(st.nextToken());

    for (int i = 1; i <= tc; i++) {
      st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int answer = solution(N);
      bw.write("#" + i + " " + answer + "\n");
    }
    bw.flush();
    bw.close();
  }

  private static int solution(int N) {
    int num = 0, cnt = 0;
    int checkBit = 0;

    while (!checkSame(checkBit)) {
      num = N * ++cnt;
      // 자릿수씩 보면서 0~9 숫자 확인해서 checkBit에 반영하기. ex ) 1234 * 1 = 1234 -> checkBit의 1, 2, 3, 4번째 비트를 1로 바꾼다.
      checkBit = parseDigit(num, checkBit);
    }

    return num;
  }

  private static boolean checkSame(int checkBit) {
    return MAX == checkBit;
  }

  private static int parseDigit(int num, int checkBit) {
    while (num > 0) {
      int digit = num % 10;
      num /= 10;
      checkBit |= 1 << digit;
    }
    return checkBit;
  }
}