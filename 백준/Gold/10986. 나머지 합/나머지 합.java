import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    long answer = 0;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    long[] restArr = new long[M];
    long prevSum = 0;
    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      prevSum += Integer.parseInt(st.nextToken());
      int remain = (int) (prevSum % M);
      if (remain == 0) {
        answer++;
      }
      restArr[remain]++;
    }

    for (int i = 0; i < M; i++) {
      answer += restArr[i] * (restArr[i] - 1) / 2;
    }

    bw.write(answer + "");
    bw.flush();
    bw.close();
  }
}
