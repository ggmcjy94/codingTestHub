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

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[K+1];
        for (int i = 1; i <= K; i++) {
            dp[i] = Integer.MAX_VALUE-1;
        }

        //3 15
        //1
        //5
        //12
        for (int i = 1; i <= N; i++) {
            for (int j = arr[i]; j <= K; j++) {
                dp[j] = Math.min(dp[j], dp[j-arr[i]] + 1);
            }
        }
        if (dp[K] == Integer.MAX_VALUE-1) {
            bw.write("-1");
        } else {
            bw.write(dp[K]+"");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}