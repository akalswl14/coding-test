import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
  private static int[] tmp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());

    tmp = new int[N];
    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      arr[i] = Integer.parseInt(st.nextToken());
    }

    mergeSort(arr, 0, N - 1);

    for (int num : arr) {
      bw.write(num + "\n");
    }
    bw.flush();
    bw.close();
  }

  private static void mergeSort(int[] arr, int start, int end) {
    if (start == end || start > end) {
      return;
    }

    int mid = start + (end - start) / 2;
    mergeSort(arr, start, mid);
    mergeSort(arr, mid + 1, end);

    merge(arr, start, mid, end);
  }

  private static void merge(int[] arr, int start, int mid, int end) {
    for (int i = start; i <= end; i++) {
      tmp[i] = arr[i];
    }

    int index1 = start;
    int index2 = mid + 1;
    int cnt = start;

    while (index1 <= mid && index2 <= end) {
      if (tmp[index1] <= tmp[index2]) {
        arr[cnt] = tmp[index1];
        index1++;
      } else {
        arr[cnt] = tmp[index2];
        index2++;
      }
      cnt++;
    }

    while (index1 <= mid) {
      arr[cnt] = tmp[index1];
      index1++;
      cnt++;
    }

    while (index2 <= end) {
      arr[cnt] = tmp[index2];
      index2++;
      cnt++;
    }
  }
}
