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
        int[] dp = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

        }
        //4
        //1 5 6 7
//        dp[1] = 1; 1
//        dp[2] = 5; 5
//        dp[3] = 6; 3 , 6 , 6
//        dp[4] = 7; 4 ,
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <=i; j++) {
                dp[i] = Math.max(dp[i], dp[i-j] + arr[j]);
            }
        }
        bw.write(dp[N]+"");
        bw.flush();
        bw.close();
        br.close();
    }
}