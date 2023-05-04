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
    char[] charArr = st.nextToken().toCharArray();
    int[] arr = new int[charArr.length];
    for (int i = 0; i < charArr.length; i++) {
      arr[i] = charArr[i] - '0';
    }

    selectionSort(arr, 0);

    for (int value : arr) {
      bw.write(value+"");
    }

    bw.flush();
    bw.close();
  }

  private static void selectionSort(int[] arr, int firstIdx) {
    int length = arr.length;
    if (firstIdx == length - 2) {
      if (arr[firstIdx] < arr[length - 1]) {
        swap(arr, firstIdx, length - 1);
      }
    } else if (firstIdx < length - 2) {
      int max = arr[firstIdx];
      int maxIdx = firstIdx;
      for (int i = firstIdx + 1; i < length; i++) {
        if (arr[i] > max) {
          max = arr[i];
          maxIdx = i;
        }
      }
      swap(arr, firstIdx, maxIdx);
      selectionSort(arr, firstIdx + 1);
    }
  }

  private static void swap(int[] arr, int idx1, int idx2) {
    int tmp = arr[idx1];
    arr[idx1] = arr[idx2];
    arr[idx2] = tmp;
  }
}
