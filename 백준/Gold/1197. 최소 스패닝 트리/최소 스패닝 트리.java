import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  private static int[] unionArr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int V = Integer.parseInt(st.nextToken());
    int E = Integer.parseInt(st.nextToken());

    unionArr = new int[V + 1];
    for (int i = 1; i <= V; i++) {
      unionArr[i] = i;
    }

    PriorityQueue<Edge> list = new PriorityQueue<>();
    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      list.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
          Integer.parseInt(st.nextToken())));
    }

    int answer = 0;
    int edgeCnt = 0;
    while (edgeCnt < V - 1 && !list.isEmpty()) {
      Edge edge = list.poll();
      int u = edge.u;
      int v = edge.v;
      if (find(u) == find(v)) {
        continue;
      }
      edgeCnt++;
      union(u, v);
      answer += edge.w;
    }

    bw.write(answer + "\n");
    bw.flush();
    bw.close();
  }

  private static int find(int u) {
    int rootU = unionArr[u];
    if (rootU == u) {
      return u;
    }
    return unionArr[u] = find(rootU);
  }

  private static void union(int u, int v) {
    int rootU = find(u);
    int rootV = find(v);
    if (rootU != rootV) {
      unionArr[rootV] = rootU;
    }
  }

  private static class Edge implements Comparable {

    int u;
    int v;
    int w;

    Edge(int u, int v, int w) {
      this.u = u;
      this.v = v;
      this.w = w;
    }

    @Override
    public int compareTo(Object o) {
      if (this == o) {
        return 0;
      }
      Edge edge = (Edge) o;
      return this.w - edge.w;
    }
  }
}
