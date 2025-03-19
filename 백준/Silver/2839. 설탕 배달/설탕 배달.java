import java.io.*;
import java.util.*;

public class Main {

    static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int cnt = 0;
        while (true) {
            if (N % 5 == 0) {
                cnt = cnt + N/5;
                break;
            } else {
                N -= 3;
                cnt++;
            }

            if(N < 0) {
                cnt = -1;
                break;
            }
        }

        bw.write(cnt+"");
        br.close();
        bw.flush();
        bw.close();
    }


}