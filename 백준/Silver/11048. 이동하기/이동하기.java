import java.io.*;
import java.util.*;

public class Main {
    static int T,N,S,E,M,R,K,min,max;
    static long ans;
    static int[][] arr;

    static int dx[] = {0, -1, 0 ,1};
    static int dy[] = {1, 0, -1, 0};
    static Queue<int[]> queue = new LinkedList<>();
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1][M+1];
        int[][] dp = new int[N+1][M+1];
        for (int i = 1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j<=M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i =1; i<=N; i++) {
            for (int j=1; j <=M; j++) {
                dp[i][j] = Math.max(arr[i][j]+dp[i-1][j] , arr[i][j] + dp[i][j-1]);
            }
        }
        bw.write(dp[N][M] + " ");
        // 1
        bw.flush();
        bw.close();
        br.close();
    }
}
