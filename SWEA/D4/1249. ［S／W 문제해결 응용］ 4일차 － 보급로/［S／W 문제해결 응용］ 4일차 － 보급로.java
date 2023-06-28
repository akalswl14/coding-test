import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    

  final static int[] dx = {0, 1, 0, -1}, dy = {-1, 0, 1, 0};
  static int tc, N, answer = Integer.MAX_VALUE;
  static int[][] map, value;
  static boolean[][] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    tc = Integer.parseInt(st.nextToken());

    for (int i = 0; i < tc; i++) {
      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());

      visited = new boolean[N][N];
      value = new int[N][N];
      map = new int[N][N];
      for (int j = 0; j < N; j++) {
        st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        for (int k = 0; k < N; k++) {
          map[j][k] = str.charAt(k) - '0';
        }
      }

      bfs();

      bw.write("#" + (i + 1) + " " + answer + "\n");
      answer = Integer.MAX_VALUE;
    }

    bw.flush();
    bw.close();
  }

  private static void bfs() {
    Queue<Node> q = new LinkedList<>();
    q.offer(new Node(0, 0));

    while (!q.isEmpty()) {
      Node node = q.poll();
      int now = value[node.x][node.y];
      if (node.x == N - 1 && node.y == N - 1) {
        answer = Math.min(answer, now);
        continue;
      }

      if (answer <= now) {
        continue;
      }

      for (int i = 0; i < 4; i++) {
        int x = node.x + dx[i];
        int y = node.y + dy[i];

        if (isValidDirection(x, y)) {
          int newValue = now + map[x][y];
          if (!visited[x][y] || value[x][y] > newValue) {
            value[x][y] = newValue;
            visited[x][y] = true;
            q.offer(new Node(x, y));
          }
        }
      }
    }
  }

  private static boolean isValidDirection(int x, int y) {
    return x >= 0 && x < N && y >= 0 && y < N;
  }

  private static class Node {

    int x;
    int y;

    Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}