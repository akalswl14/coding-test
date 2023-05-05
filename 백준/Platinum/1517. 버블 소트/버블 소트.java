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
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    long answer = mergeSort(arr, 0, N - 1);

    bw.write(answer + "");
    bw.flush();
    bw.close();
  }

  private static long mergeSort(int[] arr, int start, int end) {
    if (start == end || start > end) {
      return 0;
    }

    long sum = 0;
    int mid = start + (end - start) / 2;
    sum += mergeSort(arr, start, mid);
    sum += mergeSort(arr, mid + 1, end);

    sum += merge(arr, start, mid, end);

    return sum;
  }

  private static long merge(int[] arr, int start, int mid, int end) {
    long sum = 0;

    for (int i = start; i <= end; i++) {
      tmp[i] = arr[i];
    }

    int index1 = start;
    int index2 = mid + 1;
    int cnt = start;

    while (index1 <= mid && index2 <= end) {
      if (tmp[index1] <= tmp[index2]) {
        arr[cnt] = tmp[index1];
        if (cnt < index1) {
          sum += (index1 - cnt);
        }
        index1++;
      } else {
        arr[cnt] = tmp[index2];
        if (cnt < index2) {
          sum += (index2 - cnt);
        }
        index2++;
      }
      cnt++;
    }

    while (index1 <= mid) {
      arr[cnt] = tmp[index1];
      if (cnt < index1) {
        sum += (index1 - cnt);
      }
      index1++;
      cnt++;
    }

    while (index2 <= end) {
      arr[cnt] = tmp[index2];
      if (cnt < index2) {
        sum += (index2 - cnt);
      }
      index2++;
      cnt++;
    }

    return sum;
  }
}
