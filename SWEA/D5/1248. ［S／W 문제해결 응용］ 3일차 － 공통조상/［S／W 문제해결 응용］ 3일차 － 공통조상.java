import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution {

  static int V, E, N1, N2, ancestorId, subtreeSize;
  static Node[] nodes = new Node[10001];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int tc = Integer.parseInt(st.nextToken());

    for (int i = 1; i <= tc; i++) {
      st = new StringTokenizer(br.readLine());

      V = Integer.parseInt(st.nextToken());
      E = Integer.parseInt(st.nextToken());
      N1 = Integer.parseInt(st.nextToken());
      N2 = Integer.parseInt(st.nextToken());

      for (int j = 1; j <= V; j++) {
        nodes[j] = new Node(j);
      }
      nodes[1].h = 0;

      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < E; j++) {
        Node parent = nodes[Integer.parseInt(st.nextToken())];
        Node child = nodes[Integer.parseInt(st.nextToken())];

        if (parent.left == null) {
          parent.left = child;
        } else {
          parent.right = child;
        }
        child.prev = parent;
      }

      calculateHeightRecursive(nodes[1]);

      ancestorId = 1;
      solve();

      bw.write("#" + i + " " + ancestorId + " " + subtreeSize + "\n");
    }
    bw.flush();
    bw.close();
  }

  private static void solve() {
    subtreeSize = 0;
    Node node1 = nodes[N1];
    Node node2 = nodes[N2];
    if (node1.h < node2.h) {
      node1 = node2;
      node2 = nodes[N1];
    }

    Node parent1 = node1.prev;
    Node parent2 = node2.prev;

    while (parent1 != parent2) {
      if (node1.h == node2.h) {
        node2 = parent2;
        parent2 = node2.prev;
      }

      node1 = parent1;
      parent1 = node1.prev;
    }

    ancestorId = parent1.id;
    calculateWholeSubtreeSize(parent1);
  }

  private static void calculateHeightRecursive(Node node) {
    if (node.left != null) {
      node.left.h = node.h + 1;
      calculateHeightRecursive(node.left);
    }
    if (node.right != null) {
      node.right.h = node.h + 1;
      calculateHeightRecursive(node.right);
    }
  }

  private static void calculateWholeSubtreeSize(Node node) {
    if (node.left != null) {
      calculateWholeSubtreeSize(node.left);
    }
    if (node.right != null) {
      calculateWholeSubtreeSize(node.right);
    }
    subtreeSize++;
  }

  static class Node {

    int id;
    int number;
    int h;
    Node left;
    Node right;
    Node prev;

    Node(int id) {
      this.id = id;
    }
  }

}