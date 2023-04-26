import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static float sum = 0;
    static float max = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt((st.nextToken()));
        int M = Integer.parseInt((st.nextToken()));
        int[] arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt((st.nextToken())) + arr[i - 1];
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            bw.write(arr[y] - arr[x - 1] + "\n");
        }
        bw.flush();
        bw.close();
        return;
    }
}