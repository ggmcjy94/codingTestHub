import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //1, 1, 1, 2, 2, 3, 4, 5, 7, 9
        //2
        //6
        //12
        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        for (int i = 4; i < 101; i++) {
            dp[i] = dp[i-2] + dp[i-3];
        }

        int T = Integer.parseInt(br.readLine());
        for (int i =0; i < T; i++) {
            bw.write(dp[Integer.parseInt(br.readLine())] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
