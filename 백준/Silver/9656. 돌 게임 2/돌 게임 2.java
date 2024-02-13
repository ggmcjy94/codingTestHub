import java.io.*;
import java.util.*;

public class Main {
    static int T,N,S,E,M,R,Q,K,min,max;
    static long ans;
    static int[] arr;
    static int[] dp;
    static int dx[] = {0, -1, 0 ,1};
    static int dy[] = {1, 0, -1, 0};
    static Queue<int[]> queue = new LinkedList<>();
    static ArrayList<Integer>[] con;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        // 1 = 1 cy
        // 2 = 1 1 sk
        // 3 = 1 1 1 cy
        // 4 = 3 1 sk
        dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 1;
        for (int i = 4; i <= N; i++) {
            dp[i] = Math.min(dp[i-1], dp[i-3]) + 1;
        }
        if (dp[N] % 2 == 0) {
            bw.write("SK");
        } else {
            bw.write("CY");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
