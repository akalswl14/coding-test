import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    int answer = 0;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());

    int[] arr = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr);

    for (int i = 0; i < N; i++) {
      int target = arr[i];
      int start = 0;
      int end = N - 1;
      while (start < end) {
        int sum = arr[start] + arr[end];
        if (sum == target) {
          if(start == i){
            start++;
          } else if (end == i) {
            end--;
          } else {
            answer++;
            break;
          }
        } else if (sum < target) {
          start++;
        } else {
          end--;
        }
      }
    }

    bw.write(answer + "");
    bw.flush();
    bw.close();
  }
}
