import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br;
    static BufferedWriter bw;
    static int N,M;
    static int[][] arr;
    static boolean[] visited;
    static int[] dx = {1, 0 , -1, 0, -1, -1, 1, -1};
    static int[] dy = {0, 1 , 0, -1, 1, -1, 1, -1};
    static int max,count = 0;
    static long answer = Integer.MIN_VALUE;
    static int[] dp;

    //4
    //1 2 3
    //2 3 2
    //2 4 4

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new int[M+1];

        for (int i = N + 1; i <= M; i++) {
            if (i / 2 >= N && i % 2 == 0) {
                dp[i] = Math.min(dp[i-1],dp[i/2]) + 1;
            } else {
                dp[i] = dp[i-1] + 1;
            }
        }
        bw.write(dp[M]+"");
        bw.flush();
        bw.close();
    }
}