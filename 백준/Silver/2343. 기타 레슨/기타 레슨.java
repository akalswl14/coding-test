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
    int M = Integer.parseInt(st.nextToken());

    int[] A = new int[N];
    int start = 0;
    int end = 0;
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
      if (start < A[i]) {
        start = A[i]; // 레슨 최대값을 시작인덱스로 저장
      }
      end = end + A[i]; // 모든 레슨의 총 합을 종료 인덱스로 저장
    }
    while (start <= end) {
      int middle = (start + end) / 2;
      int sum = 0;
      int count = 0;
      for (int i = 0; i < N; i++) { // middle값으로 모든 레슨을 저장 할 수 있는지 확인
        if (sum + A[i] > middle) {
          count++;
          sum = 0;
        }
        sum = sum + A[i];
      }
      if (sum != 0) {
        count++;
      }
      if (count > M) {
        start = middle + 1;
      } else {
        end = middle - 1;
      }
    }

    bw.write(start + "");
    bw.flush();
    bw.close();
  }
}
