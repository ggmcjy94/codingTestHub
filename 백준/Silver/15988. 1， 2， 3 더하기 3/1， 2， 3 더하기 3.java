import java.io.*;
import java.util.*;

public class Main {
    static int T,N,S,E,M,R,K,min,max;
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
        // 1 : 1
        // 2 : 1+1, 2
        // 3 : 1+1+1, 1+2, 2+1, 3, 4
        // 4 : 1+1+1+1, 1+2+1, 3+1 , 2+1+1, 2+2 , 1+1+2, 1+3 = 7
        N = Integer.parseInt(br.readLine());
        long [] dp = new long[1000001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i =4; i <= 1000000; i++) {
            dp[i] = (dp[i-1] + dp[i-2]  +dp[i-3]) % 1000000009 ;
        }

        for (int i = 1; i <= N; i++) {
            int val = Integer.parseInt(br.readLine());
            System.out.println(dp[val] % 1000000009);
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
