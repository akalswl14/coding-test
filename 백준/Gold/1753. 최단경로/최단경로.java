import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int V = Integer.parseInt(st.nextToken());
    int E = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int init = Integer.parseInt(st.nextToken());

    int[] answer = new int[V + 1];
    ArrayList<Node>[] arr = new ArrayList[V + 1];
    for (int i = 0; i <= V; i++) {
      arr[i] = new ArrayList<>();
    }

    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      int w = Integer.parseInt(st.nextToken());
      arr[u].add(new Node(v, w));
    }

    for (int i = 1; i <= V; i++) {
      if (i == init) {
        answer[i] = 0;
        continue;
      }
      answer[i] = Integer.MAX_VALUE;
    }

    // init 부터 시작해서, checked=false 중 최소값 마다 체크한다.
    // 현재 값에 연결된 값들을 확인하고, 작은 값부터, 최소값으로 answer에 저장한다.
    PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
    boolean[] checked = new boolean[V + 1];
    queue.add(new Node(init, 0));
    while (!queue.isEmpty()) {
      Node node = queue.poll();
      int v = node.v;
      int w = node.w;
      if (checked[v]) {
        continue;
      }
      checked[v] = true;

      for (Node next : arr[v]) {
        if (answer[next.v] > w + next.w) {
          answer[next.v] = w + next.w;
          queue.add(new Node(next.v, answer[next.v]));
        }
      }
    }

    for (int i = 1; i <= V; i++) {
      if (i == init) {
        bw.write(0 + "\n");
      } else if (answer[i] == Integer.MAX_VALUE) {
        bw.write("INF\n");
      } else {
        bw.write(answer[i] + "\n");
      }
    }

    bw.flush();
    bw.close();
  }

  private static class Node {

    int v;
    int w;

    Node(int v, int w) {
      this.v = v;
      this.w = w;
    }
  }
}
