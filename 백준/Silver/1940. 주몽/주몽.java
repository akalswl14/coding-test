import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    int answer = 0;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    int M = Integer.parseInt(st.nextToken());

    Queue<Integer> q = new LinkedList<>();
    Map<Integer, Boolean> m = new HashMap<Integer, Boolean>();
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      int target = Integer.parseInt(st.nextToken());
      int remain = M - target;
      if (m.getOrDefault(remain, false)) {
        answer++;
      }
      m.put(target, true);
    }

    bw.write(answer + "");
    bw.flush();
    bw.close();
  }
}
