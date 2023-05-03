import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder stringBuilder = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());

    PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> {
      if (Math.abs(o1) < Math.abs(o2)) {
        return -1;
      } else if (Math.abs(o1) > Math.abs(o2)) {
        return 1;
      } else {
        return o1 - o2;
      }
    });

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int value = Integer.parseInt(st.nextToken());
      if (value == 0) {
        if (q.isEmpty()) {
          stringBuilder.append(0);
        } else {
          stringBuilder.append(q.poll());
        }
        stringBuilder.append('\n');
      } else {
        q.add(value);
      }
    }

    bw.write(stringBuilder.toString());
    bw.flush();
    bw.close();
  }
}
