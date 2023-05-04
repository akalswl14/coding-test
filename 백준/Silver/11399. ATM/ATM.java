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

    int[] arr = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    insertionSort(arr);

    int[] sum = new int[N];
    sum[0] = arr[0];
    for (int i = 1; i < N; i++) {
      sum[i] = sum[i - 1] + arr[i];
    }

    int answer = 0;
    for (int value : sum) {
      answer += value;
    }

    bw.write(answer + "");
    bw.flush();
    bw.close();
  }

  private static void insertionSort(int[] arr) {
    for (int end = 1; end < arr.length; end++) {
      int toInsert = arr[end];
      int i = end;
      while (i > 0 && arr[i - 1] > toInsert) {
        arr[i] = arr[i - 1];
        i--;
      }
      arr[i] = toInsert;
    }
  }
}
