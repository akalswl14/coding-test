import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());

    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      arr[i] = Integer.parseInt(st.nextToken());
    }

    bubbleSort(arr, arr.length - 1);

    for (int j : arr) {
      System.out.println(j);
    }
  }

  private static void bubbleSort(int[] arr, int lastIdx) {
    for (int i = 0; i < lastIdx; i++) {
      int first = arr[i];
      int second = arr[i + 1];
      if (first > second) {
        swap(arr, i, i + 1);
      }
    }
    if (lastIdx > 1) {
      bubbleSort(arr, lastIdx - 1);
    }
  }

  private static void swap(int[] arr, int idx1, int idx2) {
    int tmp = arr[idx1];
    arr[idx1] = arr[idx2];
    arr[idx2] = tmp;
  }

}
