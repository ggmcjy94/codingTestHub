import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[] selected, arr;
    static int[][] map;
    static boolean[] used;
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();
    static int white = 0;
    static int blue = 0;
    //기본) 스택,큐,우선순위큐,Deque(★),해시맵,문자열
    //초급) PriorityQueue 완전탐색
    //중급) BinarySearch DFS BFS Recursion
    //심화) Graph DP




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        long[] dp = new long[1101];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = Integer.MAX_VALUE;
        }
        //10
        //1 2 0 1 3 2 1 5 4 2
        dp[1] = 0;
        for (int i=1; i <= N; i++) {
            if (dp[i] >= Integer.MAX_VALUE) continue;
            for (int j = 1; j <= arr[i]; j++) {
                dp[i+j] = Math.min(dp[i+j], dp[i] + 1);
                // dp[2] = 1
                // dp[3] = 2
                // dp[4] = 2
                // dp[5] =  
            }
        }
        
        if (dp[N] >= Integer.MAX_VALUE) {
            bw.write("-1");
        } else {
            bw.write(dp[N]+"");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}