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
        M = Integer.parseInt(br.readLine());
        dp = new int[41];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        int ans = 1;
        int beforeSeat = 0;
        for (int i = 0; i<M; i++) {
            int temp = Integer.parseInt(br.readLine());
            ans *= dp[temp - beforeSeat - 1];
            beforeSeat = temp;
        }
        ans *= dp[N -  beforeSeat];
        bw.write(ans+"");

        bw.flush();
        bw.close();
        br.close();
    }
}
