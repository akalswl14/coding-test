import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static List<Integer> primeList = new ArrayList<>();
  static int[] odd = new int[]{1, 3, 5, 7, 9};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    if (N == 1) {
      sb.append(2).append("\n");
      sb.append(3).append("\n");
      sb.append(5).append("\n");
      sb.append(7).append("\n");
    } else {
      primeList.add(2);
      primeList.add(3);
      primeList.add(5);
      primeList.add(7);

      for (int i = 2; i <= N; i++) {
        List<Integer> digitPrimeList = new ArrayList<>();
        for (int pre : primeList) {
          for (int oddNum : odd) {
            int value = pre * 10 + oddNum;
            if (isPrime(value)) {
              digitPrimeList.add(value);
            }
          }
        }
        if (i < N) {
          primeList = digitPrimeList;
        } else {
          digitPrimeList.forEach(num -> sb.append(num).append("\n"));
        }
      }
    }

    sb.deleteCharAt(sb.length() - 1);
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }

  static private boolean isPrime(int num) {
    if (num == 1) {
      return false;
    }
    if (num == 2) {
      return true;
    }
    if (num % 2 == 0) {
      return false;
    }

    if (primeList.contains(num)) {
      return true;
    }

    for (int i = 3; i <= 9; i += 2) {
      if (num % i == 0) {
        return false;
      }
    }

    for (int i = 3; i <= num / 2; i += 2) {
      if (num % i == 0) {
        return false;
      }
    }

    return true;
  }
}
