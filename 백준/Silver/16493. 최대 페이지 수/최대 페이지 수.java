import java.io.*;
import java.util.*;

public class Main {


    static int N, M;
    static int[] vol;
    static int[][] dp, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M+1][2];
        dp = new int[M+1][N+1];
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int page = Integer.parseInt(st.nextToken());
            arr[i][0] = day;
            arr[i][1] = page;
        }

        for (int i = 1; i <=M; i++) {
            int day = arr[i][0];
            int page = arr[i][1];

            for (int j = 1; j <=N; j++) {
                dp[i][j] = dp[i-1][j];
                if ((j - day) >= 0) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-day] + page);
                }
            }
        }
        bw.write(dp[M][N] +"");
        bw.flush();
        br.close();
        bw.close();
    }
}