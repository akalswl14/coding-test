import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution {

  static int N;
  static Node[] nodes = new Node[1001];

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
        if (isOperator(data)) {
          nodes[id].operator = data;
        } else {
          nodes[id].number = Integer.parseInt(data);
        }

        if (st.hasMoreTokens()) {
          nodes[id].left = nodes[Integer.parseInt(st.nextToken())];
        }
        if (st.hasMoreTokens()) {
          nodes[id].right = nodes[Integer.parseInt(st.nextToken())];
        }
      }

      int result = inOrderRecursion(nodes[1]);

      bw.write("#" + i + " " + result + "\n");
    }
    bw.flush();
    bw.close();
  }

  private static int inOrderRecursion(Node node) {
    if (node.left == null || node.right == null) {
      return node.number;
    }
    int left = inOrderRecursion(node.left);
    int right = inOrderRecursion(node.right);
    return calculate(node.operator, left, right);
  }

  private static int calculate(String operator, int left, int right) {
    switch (operator) {
      case "+":
        return left + right;
      case "-":
        return left - right;
      case "*":
        return left * right;
      case "/":
        return left / right;
    }
    return 0;
  }

  private static boolean isOperator(String data) {
    return data.equals("+") || data.equals("-") || data.equals("*") || data.equals("/");
  }

  static class Node {

    int id;
    String operator;
    int number;
    Node left;
    Node right;

    Node(int id) {
      this.id = id;
    }
  }

}