import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

  static final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {1, -1}, {1, 1},
      {-1, 1}};
  static int N, numberOfNonBomb, clickNum;
  static int[][] map;
  static boolean[][] visited;
  static List<Cell> allClickCells;
  static boolean[] visitedAllClickCells;
  static Stack<Cell> stack;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int TC = Integer.parseInt(st.nextToken());
    for (int i = 1; i <= TC; i++) {
      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());

      map = new int[N][N]; // -2 : 지뢰, -1 : 지뢰는 아니지만 all click이 아님, -2 : all click
      visited = new boolean[N][N];
      numberOfNonBomb = 0;
      for (int j = 0; j < N; j++) {
        st = new StringTokenizer(br.readLine());
        String line = st.nextToken();
        for (int k = 0; k < N; k++) {
          map[j][k] = line.charAt(k) == '*' ? -2 : -1;
          if (map[j][k] == -1) {
            numberOfNonBomb++;
          }
        }
      }

      // AllClickCell 찾기
      allClickCells = new ArrayList<>();
      for (int j = 0; j < N; j++) {
        for (int k = 0; k < N; k++) {
          if (map[j][k] == -2) {
            continue;
          }
          if (allNonBomb(j, k)) {
            map[j][k] = allClickCells.size();
            allClickCells.add(new Cell(j, k));
          }
        }
      }
      visitedAllClickCells = new boolean[allClickCells.size()];

      if (allClickCells.size() == 0) {
        clickNum = numberOfNonBomb;
      } else {
        solve();
      }

      bw.write("#" + i + " " + clickNum + "\n");
    }
    bw.flush();
    bw.close();
  }

  private static void solve() {
    clickNum = 1;
    stack = new Stack<>();
    // AllClickCells를 하나씩 방문한다. 연쇄적으로 방문할 수 있는지도 적용한다.
    for (Cell allClickCell : allClickCells) {
      if(visitedAllClickCells[map[allClickCell.x][allClickCell.y]]){
        continue;
      }
      // 꺼낸 all click을 포함해서 연쇄적인 클릭을 모두 체크한다.
      stack.push(allClickCell);
      clickFromStack();

      // 남은 올클릭들을 클릭
      for (int i = 0; i < allClickCells.size(); i++) {
        if (visitedAllClickCells[i]) {
          continue;
        }
        stack.push(allClickCells.get(i));
        clickFromStack();
        clickNum++;
      }

      // 남은 지뢰가 아니면서 올클릭이 아닌것들 중 visited가 false인 것들을 클릭
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (map[i][j] == -1 && !visited[i][j]) {
            clickNum++;
          }
        }
      }
    }
  }

  private static void clickFromStack() {
    while (!stack.isEmpty()) {
      Cell cell = stack.pop();
      int x = cell.x;
      int y = cell.y;
      if (map[x][y] == -2) {
        continue;
      } else if (map[x][y] == -1) {
        visited[x][y] = true;
      } else {
        int idx = map[x][y];
        if (visited[x][y]) {
          continue;
        }
        visited[x][y] = true;
        visitedAllClickCells[idx] = true;

        for (int[] dir : directions) {
          int nx = x + dir[0];
          int ny = y + dir[1];
          if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
            continue;
          }
          stack.push(new Cell(nx, ny));
        }
      }
    }
  }

  private static boolean allNonBomb(int x, int y) {
    for (int[] dir : directions) {
      int dx = dir[0];
      int dy = dir[1];
      int nx = x + dx;
      int ny = y + dy;

      if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
        continue;
      }
      if (map[nx][ny] == -2) {
        return false;
      }
    }
    return true;
  }

  static class Cell {

    int x;
    int y;

    public Cell(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}