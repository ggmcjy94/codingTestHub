import java.io.*;
import java.util.*;

public class Main {
    static int T,N,M,R,K,min,max;
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
        T = Integer.parseInt(br.readLine());
        // dp[0][0] =  0 1  1
        // dp[1][0] =  0 1 1 2 3
        // dp[2][0] =  0 1 1 4 2 2 7
        // dp[3][0] =  0 1 1 6 2 4 3 2 13
        // dp[4][0] =  0 1 1 8 2 10 3 ....  41
        int[][] dp = new int[T+1][3];
        dp[1][0] = dp[1][1]= dp[1][2] = 1;
        for (int i = 2; i<=T; i++) {
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2])%9901 ;
            dp[i][1] = (dp[i-1][2] + dp[i-1][0])%9901;
            dp[i][2]= (dp[i-1][1] + dp[i-1][0]) %9901;
        }
        int res = (dp[T][0] + dp[T][1]+ dp[T][2]) % 9901;
        bw.write(res+" ");
        bw.flush();
        bw.close();
        br.close();
    }
}
