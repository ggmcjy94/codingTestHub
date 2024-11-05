import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, K;


    //3
    //4
    //7
    //10

    //4
    //8
    //14

    //1+1+1+1
    //2+1+1 (1+1+2, 1+2+1)
    //2+2
    //1+3 (3+1)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int[][] dp = new int[10001][4];
        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;
        for (int i = 4; i <= 10000; i++) {
            dp[i][1] = dp[i-1][1];
            dp[i][2] = dp[i-2][1] + dp[i-2][2];
            dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
        }

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            bw.write(dp[n][1] + dp[n][2]+dp[n][3]+"\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }
}