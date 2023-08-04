import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

  static final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
  static int N, maxCore, minWire;
  static boolean[][] processor;
  static List<Core> cores;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int TC = Integer.parseInt(st.nextToken());
    for (int i = 1; i <= TC; i++) {
      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());

      processor = new boolean[N][N];
      cores = new ArrayList<>();
      for (int j = 0; j < N; j++) {
        st = new StringTokenizer(br.readLine());
        for (int k = 0; k < N; k++) {
          int cell = Integer.parseInt(st.nextToken());
          processor[j][k] = (cell == 1);
          if (!edgeOfProcessor(j, k) && cell == 1) {
            cores.add(new Core(j, k));
          }
        }
      }

      maxCore = Integer.MIN_VALUE;
      minWire = Integer.MAX_VALUE;
      dfs(0, 0, 0);
      bw.write("#" + i + " " + minWire + "\n");
    }
    bw.flush();
    bw.close();
  }

  private static void dfs(int idx, int coreNum, int wireLength) {
    Core core = cores.get(idx);
    int x = core.x;
    int y = core.y;

    if(coreNum + (cores.size() - idx) < maxCore) return;

    for (int[] dir : directions) {
      int dx = dir[0];
      int dy = dir[1];
      int wire = isConnectable(x, y, dx, dy);

      if (idx == cores.size() - 1) {
        int resultCoreNum = coreNum;
        int resultWireLength = wireLength;
        if (wire > 0) {
          resultCoreNum++;
          resultWireLength += wire;
        }

        if (resultCoreNum > maxCore) {
          maxCore = resultCoreNum;
          minWire = resultWireLength;
        } else if (resultCoreNum == maxCore) {
          minWire = Math.min(minWire, resultWireLength);
        }
      } else {
        if (wire > 0) {
          putWire(x, y, dx, dy);
          dfs(idx + 1, coreNum + 1, wireLength + wire);
          removeWire(x, y, dx, dy);
        } else {
          dfs(idx + 1, coreNum, wireLength);
        }
      }
    }
  }

  private static int isConnectable(int x, int y, int dx, int dy) {
    int wireLength = 0; // 0이면 연결 불가능
    while (true) {
      x += dx;
      y += dy;
      wireLength++;

      if (processor[x][y]) {
        return 0;
      }

      if (edgeOfProcessor(x, y)) {
        return wireLength;
      }

    }
  }

  private static boolean edgeOfProcessor(int x, int y) {
    return (x == 0 || x == N - 1 || y == 0 || y == N - 1);
  }

  private static void putWire(int x, int y, int dx, int dy) {
    while (!edgeOfProcessor(x, y)) {
      x += dx;
      y += dy;
      processor[x][y] = true;
    }
  }

  private static void removeWire(int x, int y, int dx, int dy) {
    while (!edgeOfProcessor(x, y)) {
      x += dx;
      y += dy;
      processor[x][y] = false;
    }
  }

  static class Core {

    int x;
    int y;

    public Core(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}