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
        // dp[1] = 0 1 2 3 4 5 6 7 8 9
        //dp[2] = 55
        //dp[3] = 220
        //dp[4] = 715
        // 00
        // 01 11
        // 02 12 22
        // 03 13 23 33
        // 04 14 24 34 44
        // 05 15 25 35 45 55
        // 06 16 26 36 46 56 66
        // 07
        // 08
        // 09 19 29 39 49 59 69 79 89 99 10

        // 000
        // 001 011 111
        // 002 012 022 112 122 222
        int[][] dp = new int[1001][10];
        for (int i = 0; i <= 9; i++) dp[1][i] = 1;

        for (int i = 2; i <= 1000; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = j; k <=9; k++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][k]) % 10007;
                }
            }
        }
        long sum = 0;
        for (int j = 0; j <=9; j ++) {
            sum += dp[T][j];
        }
        bw.write(sum%10007+"\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
