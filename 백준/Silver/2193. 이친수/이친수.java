import java.io.*;
import java.util.*;

public class Main {
    static int N,M,R,K,min,max;
    static long ans;
    static int[] arr;
    static int dx[] = {0, 0, -1, -1, -1, 1, 1, 1};
    static int dy[] = {1, -1, -1, 0, 1, -1, 0, 1};
    static Queue<int[]> queue = new LinkedList<>();
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        // dp[0] = 0
        // dp[1] = 1
        // dp[2] = 10
        // dp[3] = 101 100
        // dp[4] = 1010 1000 1001
        // dp[5] = 10010 10000 10100  10101 10001
        //
        long[][] dp = new long[N+1][2];
        dp[1][1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i-1][1]; //30= 1
            dp[i][1] = dp[i -1][0];//31 = 1
        }
        long ans = dp[N][0] + dp[N][1];
        bw.write(ans+" ");
        bw.flush();
        bw.close();
        br.close();
    }
}
