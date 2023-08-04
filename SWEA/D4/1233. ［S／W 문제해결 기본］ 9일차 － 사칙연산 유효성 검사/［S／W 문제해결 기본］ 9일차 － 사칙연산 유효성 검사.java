import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution {

  static int N;
  static Node[] nodes = new Node[201];
  static boolean nextIsOperator;

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
        String data = st.nextToken();
        nodes[id].data = data;
        nodes[id].isOperator = isOperator(data);
        if (st.hasMoreTokens()) {
          nodes[id].left = nodes[Integer.parseInt(st.nextToken())];
        }
        if (st.hasMoreTokens()) {
          nodes[id].right = nodes[Integer.parseInt(st.nextToken())];
        }
      }

      nextIsOperator = false;
      int result = inOrderRecursion(nodes[1]) ? 1 : 0;

      bw.write("#" + i + " " + result + "\n");
    }
    bw.flush();
    bw.close();
  }

  private static boolean inOrderRecursion(Node node) {
    if (node.left != null) {
      if(!inOrderRecursion(node.left)) {
        return false;
      }
    }
    if (!validate(node)) {
      return false;
    }
    if (node.right != null) {
      if (!inOrderRecursion(node.right)) {
        return false;
      }
    }
    return true;
  }

  private static boolean validate(Node node) {
    if (nextIsOperator && node.isOperator) {
      nextIsOperator = false;
      return true;
    }
    if (!nextIsOperator && !node.isOperator) {
      nextIsOperator = true;
      return true;
    }
    return false;
  }

  private static boolean isOperator(String data) {
    return data.equals("+") || data.equals("-") || data.equals("*") || data.equals("/");
  }

  static class Node {

    int id;
    String data;
    Node left;
    Node right;
    boolean isOperator;

    Node(int id) {
      this.id = id;
    }
  }

}