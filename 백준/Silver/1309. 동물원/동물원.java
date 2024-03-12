import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int N,M,Q,T, K,R,C;
    static int[]dx={1,1,-1,-1};
    static int[]dy={-1,1,1,-1};
    static int[]  dp;
    static int[] arr;
    static int[][] map, room, rgb, table;
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();
    static Queue<int[]> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N+1][3];
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % 9901;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % 9901;
            dp[i][2] = (dp[i-1][1] + dp[i-1][0]) % 9901;
        }

        long res = (dp[N][0] + dp[N][1] + dp[N][2]) % 9901;
        bw.write(res +"");
        // dp[1] = 3
        // dp[2] = 7
        // dp[3] = 15
        // dp[4] = 41

        bw.flush();
        bw.close();
        br.close();
    }

}
