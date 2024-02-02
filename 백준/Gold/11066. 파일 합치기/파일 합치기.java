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
        T=Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            int[] arr = new int[N+1];
            int[][] dp = new int[N+1][N+1];
            int[][] sum = new int[N+1][N+1];

            st=new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i<= N; i++ ) {
                for (int j = i; j <= N; j++){
                    sum[i][j] = sum[i][j-1] + arr[j]; // 150 110 80 50
                }
            }

            for (int len = 2; len <= N; len++) {
                for (int i = 1; i <= N - len + 1; i++) {
                    int j = i + len - 1;
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k]+dp[k+1][j] + sum[i][j]);
                    }
                }
            }
            bw.write(dp[1][N]+"\n");
        }

        // 1
        bw.flush();
        bw.close();
        br.close();
    }
}
