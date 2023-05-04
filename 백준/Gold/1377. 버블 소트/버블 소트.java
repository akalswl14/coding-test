import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());

    Node[] arr = new Node[N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      arr[i] = new Node(i, Integer.parseInt(st.nextToken()));
    }
    Arrays.sort(arr);

    int answer = 0;
    for (int i = 0; i < N; i++) {
      int diff = arr[i].index - i;
      if (diff > answer) {
        answer = diff;
      }
    }
    answer++;

    bw.write(answer + "");
    bw.flush();
    bw.close();
  }

  static class Node implements Comparable<Node> {

    int index;
    int value;

    public Node(int index, int value) {
      this.index = index;
      this.value = value;
    }

    @Override
    public int compareTo(Node node) {
      return this.value - node.value;
    }
  }
}
