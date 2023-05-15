import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  private static boolean[] checked;
  private static ArrayList<Integer>[] arr;
  private static int[] answer;
  private static int N, M;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = new ArrayList[N + 1];
    answer = new int[N + 1];
    for (int i = 0; i <= N; i++) {
      arr[i] = new ArrayList<>();
    }
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      arr[A].add(B);
    }

    for (int i = 1; i <= N; i++) {
      checked = new boolean[N + 1];
      getHackCount(i);
    }

    int max = 0;
    for (int i = 1; i <= N; i++) {
      max = Math.max(max, answer[i]);
    }

    for (int i = 1; i <= N; i++) {
      if (answer[i] == max) {
        bw.write(i + " ");
      }
    }
    bw.flush();
    bw.close();
  }

  private static void getHackCount(int idx) {
    checked[idx] = true;
    Queue<Integer> queue = new LinkedList<>();

    queue.add(idx);
    while (!queue.isEmpty()) {
      int computer = queue.poll();
      for (int i = 0; i < arr[computer].size(); i++) {
        int next = arr[computer].get(i);
        if (!checked[next]) {
          checked[next] = true;
          queue.add(next);
          answer[next]++;
        }
      }
    }
  }
}
