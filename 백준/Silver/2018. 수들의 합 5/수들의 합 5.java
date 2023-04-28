import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    int answer = 1;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());

    int start = 1;
    int end = 1;
    int sum = 1;
    while (end < N) {
      if (sum < N) {
        end++;
        sum += end;
      } else if (sum > N) {
        sum -= start;
        start++;
      } else {
        answer++;
        end++;
        sum += (end - start);
        start++;
      }
    }

    bw.write(answer + "");
    bw.flush();
    bw.close();
  }
}
