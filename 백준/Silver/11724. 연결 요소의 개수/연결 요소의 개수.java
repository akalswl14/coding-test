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

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    boolean[][] arr = new boolean[N + 1][N + 1];
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int value1 = Integer.parseInt(st.nextToken());
      int value2 = Integer.parseInt(st.nextToken());
      arr[value1][value2] = true;
      arr[value2][value1] = true;
    }

    int sum = 0;
    boolean[] checked = new boolean[N + 1];
    Stack<Integer> s = new Stack<>();
    for (int i = 1; i <= N; i++) {
      if (checked[i]) {
        continue;
      }
      checked[i] = true;
      s.add(i);
      recursive(arr, checked, N, s);
      sum++;
    }

    bw.write(sum + "\n");
    bw.flush();
    bw.close();
  }

  private static void recursive(boolean[][] arr, boolean[] checked, int N, Stack<Integer> s) {
    while (!s.isEmpty()) {
      int target = s.pop();

      for (int i = 1; i <= N; i++) {
        if (arr[target][i] && !checked[i]) {
          checked[i] = true;
          s.add(i);
        }
      }
    }
  }
}
