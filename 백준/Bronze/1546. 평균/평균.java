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
        float N = Float.parseFloat(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            float temp = Float.parseFloat(st.nextToken());
            if (temp > max) {
                max = temp;
            }
            sum += temp;
        }
        bw.write((sum / max * 100 / N) + "");
        bw.flush();
        bw.close();
        return;
    }
}