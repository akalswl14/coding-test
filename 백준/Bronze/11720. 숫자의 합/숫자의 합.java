import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        for (int i = 0; i < N; i++) {
            sum += (str.charAt(i) - '0');
        }
        bw.write(sum + "");
        bw.flush();
        bw.close();
        return;
    }
}