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
    int M = Integer.parseInt(st.nextToken());

    int[][] arr = new int[N + 1][M + 1];
    boolean[][] checked = new boolean[N + 1][M + 1];
    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      char[] chars = st.nextToken().toCharArray();
      for (int j = 1; j <= M; j++) {
        if (chars[j - 1] == '1') {
          arr[i][j] = 1;
        }
      }
    }

    Queue<Node> q = new LinkedList<>();
    q.add(new Node(1, 1));
    checked[1][1] = true;

    int answer = 0;
    while (!q.isEmpty()) {
      Node target = q.poll();

      // E
      if (target.m < M && arr[target.n][target.m + 1] != 0 && !checked[target.n][target.m + 1]) {
        q.add(new Node(target.n, target.m + 1));
        arr[target.n][target.m + 1] = arr[target.n][target.m] + 1;
        checked[target.n][target.m + 1] = true;
      }
      // S
      if (target.n < N && arr[target.n + 1][target.m] != 0 && !checked[target.n + 1][target.m]) {
        q.add(new Node(target.n + 1, target.m));
        arr[target.n + 1][target.m] = arr[target.n][target.m] + 1;
        checked[target.n + 1][target.m] = true;
      }
      // N
      if (target.n > 1 && arr[target.n - 1][target.m] != 0 && !checked[target.n - 1][target.m]) {
        q.add(new Node(target.n - 1, target.m));
        arr[target.n - 1][target.m] = arr[target.n][target.m] + 1;
        checked[target.n - 1][target.m] = true;
      }
      // W
      if (target.m > 1 && arr[target.n][target.m - 1] != 0 && !checked[target.n][target.m - 1]) {
        q.add(new Node(target.n, target.m - 1));
        arr[target.n][target.m - 1] = arr[target.n][target.m] + 1;
        checked[target.n][target.m - 1] = true;
      }
    }

    bw.write(arr[N][M] + "");
    bw.flush();
    bw.close();
  }

  static class Node {

    int n;
    int m;

    Node(int n, int m) {
      this.n = n;
      this.m = m;
    }

    boolean equals(Node node) {
      return node.n == this.n && node.m == this.m;
    }
  }
}
