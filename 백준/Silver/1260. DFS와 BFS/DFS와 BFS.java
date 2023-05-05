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

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int V = Integer.parseInt(st.nextToken());

    boolean[][] arr = new boolean[N + 1][N + 1];
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int value1 = Integer.parseInt(st.nextToken());
      int value2 = Integer.parseInt(st.nextToken());
      arr[value1][value2] = true;
      arr[value2][value1] = true;
    }

    boolean[] checked = new boolean[N + 1];
    checked[V] = true;
    String dfsStr = dfs(arr, checked, N, V);

    checked = new boolean[N + 1];
    String bfsStr = bfs(arr, checked, N, V);

    bw.write(dfsStr + "\n");
    bw.write(bfsStr + "\n");
    bw.flush();
    bw.close();
  }

  private static String bfs(boolean[][] arr, boolean[] checked, int N, int idx) {
    StringBuilder sb = new StringBuilder();

    Queue<Integer> q = new LinkedList<>();
    checked[idx] = true;
    q.add(idx);

    while (!q.isEmpty()) {
      int target = q.poll();
      sb.append(target).append(' ');
      for (int i = 1; i <= N; i++) {
        if (arr[target][i] && !checked[i]) {
          checked[i] = true;
          q.add(i);
        }
      }
    }

    return sb.toString();
  }

  private static String dfs(boolean[][] arr, boolean[] checked, int N, int idx) {
    StringBuilder sb = new StringBuilder();
    sb.append(idx).append(' ');
    for (int i = 1; i <= N; i++) {
      if (arr[idx][i] && !checked[i]) {
        checked[i] = true;
        sb.append(dfs(arr, checked, N, i));
      }
    }
    return sb.toString();
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
