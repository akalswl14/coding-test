import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  private static int[] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    arr = new int[N + 1];
    for (int i = 0; i <= N; i++) {
      arr[i] = i;
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      int C = Integer.parseInt(st.nextToken());
      if (A == 0) {
        // B, C를 하나의 집합으로 생각
        union(B, C);
      } else {
        // B, C가 같은 집합인지 출력
        if (find(B) == find(C)) {
          bw.write("YES\n");
        } else {
          bw.write("NO\n");
        }
      }
    }

    bw.flush();
    bw.close();
  }

  private static void union(int a, int b) {
    if (a == b) {
      return;
    }
    int rootA = find(a);
    int rootB = find(b);
    if (rootA != rootB) {
      arr[rootB] = rootA;
    }
  }

  private static int find(int a) {
    if (arr[a] == a) {
      return a;
    }
    return arr[a] = find(arr[a]);
  }
}
