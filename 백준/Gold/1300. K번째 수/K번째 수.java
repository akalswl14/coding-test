import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    int K = Integer.parseInt(st.nextToken());

    int start = 1;
    int end = K;
    int middle = N / 2;
    int answer = 0;
    while (start <= end) {
      int sum = 0;
      for (int i = 1; i <= N; i++) {
        if (middle / i == 0) {
          break;
        }
        sum += Math.min(middle / i, N);
      }

      if (sum >= K) {
        answer = middle;
        end = middle - 1;
      } else {
        start = middle + 1;
      }
      middle = (start + end) / 2;
    }

    bw.write(answer + "");
    bw.flush();
    bw.close();
  }
}
