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
    int max = 1;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int value = Integer.parseInt(st.nextToken());
      arr[i] = value;
      if (value > max) {
        max = value;
      }
    }

    int[] countingArr = new int[max + 1];
    for (int num : arr) {
      countingArr[num]++;
    }

    for (int i = 1; i<=max;i++) {
      int cnt = countingArr[i];
      for (int j = 0; j < cnt; j++) {
        bw.write(i + "\n");
      }
    }

    bw.flush();
    bw.close();
  }
}
