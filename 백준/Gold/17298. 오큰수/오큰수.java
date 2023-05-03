import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder stringBuilder = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());

    int[] arr = new int[N];
    int[] answer = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Stack<Integer> s = new Stack<>();
    s.add(0);
    for (int i = 1; i < N; i++) {
      int target = arr[i];
      while (!s.isEmpty() && arr[s.peek()] < target) {
        answer[s.pop()] = target;
      }
      s.add(i);
    }
    while (!s.isEmpty()) {
      answer[s.pop()] = -1;
    }

    for (int i = 0; i < N - 1; i++) {
      stringBuilder.append(answer[i]).append(" ");
    }
    stringBuilder.append(-1);
    bw.write(stringBuilder.toString());
    bw.flush();
    bw.close();
  }
}
