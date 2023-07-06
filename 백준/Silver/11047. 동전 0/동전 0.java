import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken());
      list.add(A);
    }

    int cnt = getRemainder(list, K);

    bw.write(String.valueOf(cnt));
    bw.flush();
  }

  private static int getRemainder(List<Integer> list, int k) {
    int divider = 0;
    for (int x : list) {
      if (x <= k) {
        divider = x;
      } else {
        break;
      }
    }
    int cnt = k / divider;
    if (k % divider != 0) {
      cnt += getRemainder(list, k % divider);
    }
    return cnt;
  }
}
