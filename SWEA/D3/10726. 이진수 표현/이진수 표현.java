import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int tc = Integer.parseInt(st.nextToken());

    for (int i = 1; i <= tc; i++) {
      st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());

      int checkBit = createCheckBit(N);
      boolean on = validateBit(checkBit, M);
      
      bw.write("#" + i + " " + (on ? "ON" : "OFF") + "\n");
    }
    bw.flush();
    bw.close();
  }

  private static int createCheckBit(int n) {
    int checkBit = 0;
    while (n > 0) {
      n--;
      checkBit |= 1 << n;
    }
    return checkBit;
  }

  private static boolean validateBit(int checkBit, int num) {
    return (num | checkBit) == num;
  }
}