import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution {

  static int N;
  static Node[] nodes = new Node[101];
  static StringBuilder sb;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st;

//    int tc = Integer.parseInt(st.nextToken());

    for (int i = 1; i <= 10; i++) {
      st = new StringTokenizer(br.readLine());

      N = Integer.parseInt(st.nextToken());
      for (int j = 1; j <= N; j++) {
        nodes[j] = new Node(j);
      }

      for (int j = 0; j < N; j++) {
        st = new StringTokenizer(br.readLine());

        int id = Integer.parseInt(st.nextToken());
        nodes[id].data = st.nextToken();
        if (st.hasMoreTokens()) {
          nodes[id].left = nodes[Integer.parseInt(st.nextToken())];
        }
        if (st.hasMoreTokens()) {
          nodes[id].right = nodes[Integer.parseInt(st.nextToken())];
        }
      }

      sb = new StringBuilder();
      inOrderRecursion(sb, nodes[1]);

      bw.write("#" + i + " " + sb.toString() + "\n");
    }
    bw.flush();
    bw.close();
  }

  private static void inOrderRecursion(StringBuilder sb, Node node) {
    if (node.left != null) {
      inOrderRecursion(sb, node.left);
    }
    sb.append(node.data);
    if (node.right != null) {
      inOrderRecursion(sb, node.right);
    }
  }

  static class Node {

    int id;
    String data;
    Node left;
    Node right;

    Node(int id) {
      this.id = id;
    }
  }

}