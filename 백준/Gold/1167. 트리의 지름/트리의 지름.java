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

  private static final Queue<Node> q = new LinkedList<>();
  private static ArrayList<Node>[] list;
  private static boolean[] visited;
  private static int[] dist;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int V = Integer.parseInt(st.nextToken());

    list = new ArrayList[V + 1];

    for (int i = 0; i < V; i++) {
      st = new StringTokenizer(br.readLine());
      int index = Integer.parseInt(st.nextToken());
      list[index] = new ArrayList<>();

      int j = Integer.parseInt(st.nextToken());
      while (j != -1) {
        int d = Integer.parseInt(st.nextToken());
        list[index].add(new Node(j, d));
        j = Integer.parseInt(st.nextToken());
      }
    }

    int maxIdx = getDia(1);
    maxIdx = getDia(maxIdx);

    bw.write(dist[maxIdx] + "");
    bw.flush();
    bw.close();
  }

  private static int getDia(int index) {
    int V = list.length - 1;
    visited = new boolean[V + 1];
    dist = new int[V + 1];

    q.add(new Node(index, 0));
    while (!q.isEmpty()) {
      recursion();
    }
    int max = dist[1];
    int maxIdx = 1;
    for (int i = 2; i <= V; i++) {
      if (max < dist[i]) {
        maxIdx = i;
        max = dist[i];
      }
    }
    return maxIdx;
  }

  private static void recursion() {
    Node now = q.poll();
    int index = now.index;
    int sum = now.dist;

    visited[index] = true;
    for (Node node : list[index]) {
      int targetIdx = node.index;
      if (!visited[targetIdx]) {
        int targetDist = node.dist + sum;
        dist[targetIdx] = targetDist;
        q.add(new Node(targetIdx, targetDist));
      }
    }
  }

  private static class Node {

    int index;
    int dist;

    Node(int index, int dist) {
      this.index = index;
      this.dist = dist;
    }
  }
}
