import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, K;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        //11
//8 3 2 4 8 7 2 4 0 8 8
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N-1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int t = Integer.parseInt(st.nextToken());
        long[][] dp = new long[N+1][21];
        dp[1][arr[1]] = 1;
        for (int i = 1; i <= N-2; i++) {
            for (int j = 0; j <= 20; j++) {
                if (dp[i][j] != 0) {
                   int p = j + arr[i+1];
                   int m = j - arr[i+1];
                   if (p >= 0 && p <= 20) {
                       dp[i+1][p] += dp[i][j];
                   }
                   if (m >= 0 && m <= 20) {
                       dp[i+1][m] += dp[i][j];
                   }
                }
            }
        }
        bw.write(dp[N-1][t]+"");
        bw.flush();
        bw.close();
        br.close();

    }
}