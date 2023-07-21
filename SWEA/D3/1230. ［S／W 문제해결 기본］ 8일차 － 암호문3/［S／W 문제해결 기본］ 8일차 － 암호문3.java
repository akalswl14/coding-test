import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;


class Solution {

  static final String INSERT = "I", DELETE = "D", ADD = "A";
  static List<String> list;
  static int N, M, x, y;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

    int tc = 10;

    for (int i = 1; i <= tc; i++) {
      list = new LinkedList<>();

      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        list.add(st.nextToken());
      }

      st = new StringTokenizer(br.readLine());
      M = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        String command = st.nextToken();
        runCommand(command, st);
      }

      int max = Math.min(list.size(), 10);
      bw.write("#" + i);
      for (int j = 0; j < max; j++) {
        bw.write(" " + list.get(j));
      }
      bw.newLine();
    }
    bw.flush();
    bw.close();
  }

  private static void runCommand(String command, StringTokenizer st) {
    if (command.equals(INSERT)) {
      x = Integer.parseInt(st.nextToken());
      y = Integer.parseInt(st.nextToken());
      while (y-- > 0) {
        list.add(x++, st.nextToken());
      }
    } else if (command.equals(DELETE)) {
      x = Integer.parseInt(st.nextToken());
      y = Integer.parseInt(st.nextToken());
      while (y-- > 0) {
        list.remove(x);
      }
    } else if (command.equals(ADD)) {
      y = Integer.parseInt(st.nextToken());
      while (y-- > 0) {
        list.add(st.nextToken());
      }
    }
  }
}