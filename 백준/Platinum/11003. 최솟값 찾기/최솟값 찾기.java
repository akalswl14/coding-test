import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    Deque<Node> q = new LinkedList<>();

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int L = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      int value = Integer.parseInt(st.nextToken());
      Node node = new Node(value, i);

      if (i == 0) {
        q.addFirst(node);
        bw.write(value + "");
      } else {
        while (!q.isEmpty() && (q.getLast().value > value)) {
          q.removeLast();
        }
        q.addLast(node);
        if (q.getFirst().index == i - L) {
          q.removeFirst();
        }
        bw.write(" " + q.getFirst().value);
      }
    }
    bw.flush();
    bw.close();
  }

  static class Node {

    int value;
    int index;

    public Node(int value, int index) {
      this.value = value;
      this.index = index;
    }
  }
}
