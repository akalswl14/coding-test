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
    int N = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    int K = Integer.parseInt(st.nextToken());

    /*
      A[i][j]에서 i*j = x일때, 배열 B에서 x의 값이 존재하는 최대 인덱스를 구하고 싶다.
      - x는 i보다 작을 수 없다. 즉, i는 x보다 작거나 같다.
      - 배열 B에서 x의 값이 존재하는 최대 인덱스는 A[0]~A[x]를 확인해야한다.
      - 배열 B에서 x의 값이 존재하는 최대 인덱스는 각 i행에서 x/A[i]를 연산한 합이다. ( 단, 연산값이 N보다 클 수 없다. )

      예를 들어, N = 3, K = 7 이라고 문제에서 주어진다면,
      A[1] : 7/1 = 7 > N => N
      A[2] : 7/2 = 3
      A[3] : 7/3 = 2
      총합 : 8
      B에 저장된 i*j = 7 이전의 값 : 1*1, 1*2, 1*3, 2*1, 2*2, 2*3, 3*1, 3*2 => 8개

      따라서, 아래와 같이 풀이한다.
      1. i*j = x의 x가 i보다 작을 수 없으므로, 시작값 : 1, 종료값 : x로, 중앙값 : x/2로 이진 탐색한다.
      2. 각 중앙값에 대해, 중앙값/i의 총합을 계산한다.
      3. 계산한 총합이 K보다 작다면, 중앙값보다 더 뒤에 있는 값에 정답이 있으므로 시작값 : 중앙값 + 1로 설정한다.
      4. 계산한 총합이 K보다 크거나 같다면, 중앙값보다 더 앞에 있는 값이나 종료값에 정답이 있으므로 종료값 : 중앙값 - 1로 설정하고,
         이 때의 중앙값이 정답일 수도 있으므로, 이 중앙값을 정답값으로 저장해둔다.
      5. 시작값이 중앙값보다 커지게되면, 연산을 종료한다.
    */

    int start = 1;
    int end = K;
    int middle = N / 2;
    int answer = 0;
    while (start <= end) {
      int sum = 0;
      for (int i = 1; i <= N; i++) {
        if (middle / i == 0) {
          break;
        }
        sum += Math.min(middle / i, N);
      }

      if (sum >= K) {
        answer = middle;
        end = middle - 1;
      } else {
        start = middle + 1;
      }
      middle = (start + end) / 2;
    }

    bw.write(answer + "");
    bw.flush();
    bw.close();
  }
}
