import java.io.*;
import java.util.StringTokenizer;

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        long answer = 0;
        long [] dp = new long[N+2];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 0; i <= N - 2; i++) {
            dp[i+2] = dp[i] + dp[i+1];
        }

        answer = dp[N] * 4 + 2 * dp[N-1];
        bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();

    }
}