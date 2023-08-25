import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        // 5 2
        // 15
        // 13 - 5  8
        int cnt =0;

        while (N > 0) {
            if (N % 5 ==0) {
                 cnt = N / 5 + cnt;
                 break;
            }
            N -= 2;
            cnt++;
        }
        if (N < 0) {
            bw.write(-1+"");
        } else {
            bw.write(cnt + "");
        }
        bw.flush();
        bw.close();
    }
}