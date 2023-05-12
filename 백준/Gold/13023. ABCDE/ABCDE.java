import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

  static boolean[] visited;
  static ArrayList<Integer>[] friends;
  static int N;
  static int size = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    visited = new boolean[N];
    friends = new ArrayList[N];
    for (int i = 0; i < N; i++) {
      friends[i] = new ArrayList<>();
    }
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      friends[a].add(b);
      friends[b].add(a);
    }

    int answer = 0;
    for (int i = 0; i < N; i++) {
      if (recursion(i)) {
        answer = 1;
        break;
      }
    }

    bw.write(answer + "");
    bw.flush();
    bw.close();
  }

  private static boolean recursion(int index) {
    visited[index] = true;
    size++;
    for (int i : friends[index]) {
      if (!visited[i]) {
        if (size == 4) {
          return true;
        }
        if (recursion(i)) {
          return true;
        }
      }
    }
    visited[index] = false;
    size--;
    return false;
  }
}
