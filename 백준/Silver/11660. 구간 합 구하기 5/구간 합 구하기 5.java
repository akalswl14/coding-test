import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt((st.nextToken()));
        int M = Integer.parseInt((st.nextToken()));
        int[][] arr = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt((st.nextToken())) + arr[i][j - 1];
            }
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int sum = 0;
            for (int j = x2; j >= x1; j--) {
                sum += arr[j][y2] - arr[j][y1 - 1];
            }
            bw.write(sum + "\n");
        }
        bw.flush();
        bw.close();
        return;
    }
}