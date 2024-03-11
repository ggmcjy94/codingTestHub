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
    static int[][] map, room, rgb;
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();
    static Queue<int[]> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N+1][3];
        rgb = new int[N+1][3];
        for (int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            rgb[i][0] = R;
            rgb[i][1] = G;
            rgb[i][2] = B;
        }

        dp[1][0] = rgb[1][0];
        dp[1][1] = rgb[1][1];
        dp[1][2] = rgb[1][2];

        for (int i = 2; i<= N; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + rgb[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + rgb[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + rgb[i][2];
        }

        int res = Math.min(dp[N][0],Math.min(dp[N][1] , dp[N][2]));
        bw.write(res+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
