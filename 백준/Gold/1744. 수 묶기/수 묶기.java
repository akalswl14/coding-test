import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());

    if (N == 1) {
      st = new StringTokenizer(br.readLine());
      bw.write(st.nextToken());
      bw.flush();
      return;
    }

    PriorityQueue<Integer> positiveQueue = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> negativeQueue = new PriorityQueue<>();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      if(x > 0) {
        positiveQueue.add(x);
      } else {
        negativeQueue.add(x);
      }
    }

    int sum = getSum(positiveQueue) + getSum(negativeQueue);

    bw.write(String.valueOf(sum));
    bw.flush();
  }

  private static int getSum(PriorityQueue<Integer> queue) {
    int x, y, multiply, plus, sum = 0;

    while (!queue.isEmpty()) {
      x = queue.poll();
      if (queue.isEmpty()) {
        sum += x;
        break;
      }

      y = queue.peek();
      multiply = x * y;
      plus = x + y;

      if (multiply > plus) {
        queue.poll();
        sum += multiply;
      } else {
        sum += x;
      }
    }
    return sum;
  }
}
