import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());

    Queue<Integer> q = new LinkedList<>();
    for (int i = 1; i <= N; i++) {
      q.add(i);
    }

    for (int i = 0; i < N - 1; i++) {
      q.poll();
      q.add(q.poll());
    }
    bw.write(q.poll() + "");
    bw.flush();
    bw.close();
  }
}
