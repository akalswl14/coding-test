import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());

    PriorityQueue<Integer> queue = new PriorityQueue<>();
    if (N == 1) {
      bw.write("0");
      bw.flush();
      return;
    }

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      queue.add(Integer.parseInt(st.nextToken()));
    }

    int cnt = 0;
    int a = queue.poll();
    while(queue.size() >= 1) {
      int b = queue.poll();
      if(a > b){
        queue.add(a);
        a = queue.poll();
      }
      int c = a+ b;
      cnt += c;
      a = c;
    }

    bw.write(String.valueOf(cnt));
    bw.flush();
  }
}