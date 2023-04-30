import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder stringBuilder = new StringBuilder();

    Stack<Integer> s = new Stack<>();
    Queue<Integer> q = new LinkedList<>();

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int value = Integer.parseInt(st.nextToken());
      q.add(value);
    }

    boolean[] alreadyPop = new boolean[N + 1];
    int cnt = 1;
    boolean impossible = false;
    while (!q.isEmpty() && !impossible) {
      int target = q.poll();
      if (target < cnt) {
        cnt = target;
      }
      for (int i = cnt; i <= target; i++) {
        if (i == target) {
          if (!s.isEmpty() && s.peek() == target) {
            s.pop();
            stringBuilder.append("-\n");
          } else if (s.isEmpty() || s.peek() < i) {
            stringBuilder.append("+\n-\n");
            cnt++;
          } else {
            impossible = true;
            break;
          }
          alreadyPop[i] = true;
        } else {
          if (!alreadyPop[i]) {
            s.add(i);
            stringBuilder.append("+\n");
          }
          cnt++;
        }
      }
    }
    if (impossible) {
      bw.write("NO");
    } else {
      stringBuilder.deleteCharAt(stringBuilder.length() - 1);
      bw.write(stringBuilder.toString());
    }
    bw.flush();
    bw.close();
  }
}
