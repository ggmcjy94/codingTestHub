import java.io.*;
import java.util.*;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        long[] dp = new long[36];

        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= 35; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += (dp[j] * dp[i-j-1]);
            }
        }
        bw.write(dp[N]+"");

        bw.flush();
        bw.close();
        br.close();
    }

}