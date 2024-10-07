import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[][] map;
    static int[] dx = {0,1};
    static int[] dy = {1,0};
    static boolean[][] visited;
    static boolean[][] top;
    static int w = 0;
    //기본) 스택,큐,우선순위큐,Deque(★),해시맵,문자열
    //초급) PriorityQueue 완전탐색
    //중급) BinarySearch DFS BFS Recursion
    //심화) Graph DP
    static void bfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r,c});
        visited[r][c] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nox = poll[0];
            int noy = poll[1];
            for (int i = 0; i < 2; i++) {
                int nex = dx[i] + nox;
                int ney = dy[i] + noy;
                if (nex < 0 || nex >= N  || ney < 0 || ney >= M) continue;
                if (visited[nex][ney]) continue;
                if (map[nex][ney] == 0) continue;
                queue.add(new int[]{nex, ney});
                visited[nex][ney] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 1;
        dp[4] = 1;
        for (int i = 5; i <= N; i++ ) {
            dp[i] = 2;
            if (dp[i-1] % 2 == 0 || dp[i-3] % 2 == 0 || dp[i-4] % 2 == 0) {
                dp[i] = 1;
            }
        }
        if (dp[N] == 1) {
            bw.write("SK");
        } else {
            bw.write("CY");
        }
        // 6
        bw.flush();
        bw.close();
        br.close();
    }
}