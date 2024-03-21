import java.io.*;
import java.util.*;

public class Main {

    static int N,M,C,R,T,A,B;
    static int ans;
    static StringTokenizer st;
    static int[] dx = {1,0,-1,0,1,-1,-1,1};
    static int[] dy = {0,1,0,-1,1,1,-1,-1};
    static int[][] arr, brr;
    static ArrayList<Integer>[] graph;
    static char[][] map;
    static Queue<int[]> iceQueue;
    static boolean[][] visited;
    static boolean[] visit;
    static int[] dist;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        Long[][] dp =new Long[N+1][10];
        for (int i = 0; i<=9; i++) {
            dp[1][i] = 1L;
        }

        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i-1][1];

            for (int j = 1; j <= 9; j++) {
                if (j==9) dp[i][9] = dp[i-1][8] % 1000000000L;
                else dp[i][j] = (dp[i-1][j-1] % 1000000000L + dp[i-1][j+1] % 1000000000L) % 1000000000L;
            }
        }
        // 1 2 3 4 5 6 7 8 9
        //
        // 10 12  21 23  32 34  43 45  54 56  65 67  76 78  87 89  98
        //
        long result = 0;
        for (int i = 1; i <= 9; i++) {
            result =  (result +dp[N][i]) % 1000000000L;
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
        br.close();

    }

}

