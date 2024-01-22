import java.io.*;
import java.util.*;

public class Main {
    static int N,M,R,K,min,max;
    static long ans;
    static int dx[] = {0, 0, -1, -1, -1, 1, 1, 1};
    static int dy[] = {1, -1, -1, 0, 1, -1, 0, 1};
    static Queue<int[]> queue = new LinkedList<>();
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int[] dp = new int[11];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i < 11; i++) {
            dp[i] = dp[i-3] +dp[i-2] + dp[i-1];
        }
        for (int i = 0; i< N; i++) {
            bw.write(dp[Integer.parseInt(br.readLine())] +"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
