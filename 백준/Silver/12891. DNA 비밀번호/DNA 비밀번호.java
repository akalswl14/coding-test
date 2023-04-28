import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

  static char[] arr;
  static int P, A, C, G, T;
  static int cntA = 0, cntC = 0, cntG = 0, cntT = 0, answer = 0;


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int S = Integer.parseInt(st.nextToken());
    P = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    arr = st.nextToken().toCharArray();

    st = new StringTokenizer(br.readLine());
    A = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    G = Integer.parseInt(st.nextToken());
    T = Integer.parseInt(st.nextToken());

    for (int i = 0; i < P; i++) {
      count(i, true);
    }
    valid();

    for (int i = P; i < S; i++) {
      count(i, true);
      count(i - P, false);
      valid();
    }

    bw.write(answer + "");
    bw.flush();
    bw.close();
  }

  private static void count(int index, boolean add) {
    int adder = 1;
    if (!add) {
      adder = -1;
    }
    char target = arr[index];
    if (target == 'A') {
      cntA += adder;
    } else if (target == 'C') {
      cntC += adder;
    } else if (target == 'G') {
      cntG += adder;
    } else {
      cntT += adder;
    }
  }

  private static void valid() {
    if (cntA >= A && cntC >= C && cntG >= G && cntT >= T) {
      answer++;
    }
  }
}
