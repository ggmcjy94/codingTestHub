import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, K;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        K = 99;
        int[][] dp = new int[N+1][K+1];
        int[] w = new int[N+1];
        int[] v = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            w[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            v[i] = Integer.parseInt(st.nextToken());
        }
        //3
        //1 21 79 체력
        //20 30 25 기쁨
        // 50
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (w[i] <= j) {
                    dp[i][j] = Math.max(dp[i-1][j - w[i]]+ v[i], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        bw.write(dp[N][K]+"");
        bw.flush();
        bw.close();
        br.close();

    }
}