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
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] dp = new int[n+1][2];
            int[][] arr = new int[n+1][2];
            for (int e = 0; e<2; e++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    arr[j][e] = Integer.parseInt(st.nextToken());
                }
            }
            dp[1][0] = arr[1][0];
            dp[1][1] = arr[1][1];
            // 30 = 200
            // 31 = 110
            // 20 = 40
            // 21 = 100 
            for (int c = 2; c <= n; c++) {
                dp[c][0] = Math.max(dp[c-1][1],dp[c-2][1]) + arr[c][0];
                dp[c][1]= Math.max(dp[c-1][0],dp[c-2][0]) + arr[c][1];
            }
            bw.write(Math.max(dp[n][0], dp[n][1]) +"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
