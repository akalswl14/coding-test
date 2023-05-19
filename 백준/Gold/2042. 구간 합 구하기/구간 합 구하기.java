import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken()); // Number of given number
    int M = Integer.parseInt(st.nextToken()); // 변경 횟수
    int K = Integer.parseInt(st.nextToken()); // 구간 합을 구하는 횟수

    // 세그먼트 트리 1차원 배열의 크기 : 2^depth >= N를 구해서, 2^(depth + 1)로 설정.
    int depth = 0;
    while (Math.pow(2, depth) < N) {
      depth++;
    }
    int treeSize = (int) Math.pow(2, depth + 1);
    long[] tree = new long[treeSize];

    // 세그먼트 트리 초기화
    int numberStartIdx = treeSize / 2; // 2^depth
    for (int i = numberStartIdx; i < numberStartIdx + N; i++) {
      st = new StringTokenizer(br.readLine());
      tree[i] = Long.parseLong(st.nextToken());
    }

    // 구간합 계산
    for (int i = treeSize - 1; i > 1; i -= 2) {
      tree[i / 2] += tree[i] + tree[i - 1];
    }

    // a = 1 : b번째 수를 c로 바꾼다.
    // a = 2 : b번째 수부터 c번째 수까지의 합을 구하여 출력한다.
    // 주어진 인덱스는 x+numberStartIdx-1로 계산해야한다.
    for (int i = 0; i < M + K; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      long c = Long.parseLong(st.nextToken());

      if (a == 1) {
        // b번째 수를 c로 바꾼다.
        long diff = c - tree[numberStartIdx + b - 1];
        tree[numberStartIdx + b - 1] = c;
        int parent = (numberStartIdx + b - 1) / 2;
        while (parent > 0) {
          tree[parent] += diff;
          parent /= 2;
        }
      } else {
        // b번째 수부터 c번째 수까지의 합을 구하여 출력한다.
        // 1. startIndex % 2 == 1이면 선택 리스트에 넣는다.
        // 2. endIndex % 2 == 0이면 선택 리스트에 넣는다.
        // 3. start Index가 선택되었으면, startIndex = (startIndex+1)/2이다. 그게 아니면 그냥 startIndex/2이다.
        // 4. end Index가 선택되었으면, endIndex = (endIndex-1)/2이다. 그게 아니면 그냥 endIndex/2이다.
        long sum = 0;
        int start = numberStartIdx + b - 1;
        int end = numberStartIdx + (int) c - 1;
        while (start <= end) {
          if (start % 2 == 1) {
            sum += tree[start];
            start++;
          }
          if (end % 2 == 0) {
            sum += tree[end];
            end--;
          }
          start /= 2;
          end /= 2;
        }
        bw.write(sum + "\n");
      }
    }

    bw.flush();
    bw.close();
  }
}
