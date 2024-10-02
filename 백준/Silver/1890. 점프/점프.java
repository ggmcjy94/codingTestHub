import java.io.*;
import java.util.*;

public class Main {
    static int N,M,K;
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
        //4
        //2 3 3 1
        //1 2 1 3
        //1 2 3 1
        //3 1 1 0
        int[][] arr = new int[N+1][N+1];
        long[][] dp = new long[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[1][1] = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int nxt = arr[i][j];
                if (nxt == 0) break;
                if (i + nxt <= N) dp[i+nxt][j] += dp[i][j];
                if (j + nxt <= N) dp[i][j+nxt] += dp[i][j];
            }
        }
        bw.write(dp[N][N]+"");
        bw.flush();
        bw.close();
        br.close();
    }
}