import java.io.*;
import java.util.*;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        long[] dp = new long[68];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= 67; i++) {
            dp[i] = dp[i-1]+dp[i-2]+dp[i-3]+dp[i-4];
        }

        for (int i = 0; i < N; i++) {
            int i1 = Integer.parseInt(br.readLine());
            bw.write(dp[i1]+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}