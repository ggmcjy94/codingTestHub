import java.io.*;
import java.util.*;

public class Main {
    static int N,M,K;
    static int[] selected, arr;
    static int[][] map;
    static boolean[] used;
    static int[] dx = {0 , 1};
    static int[] dy = {1 , 0};
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();
    static int white = 0;
    static int blue = 0;
    //기본) 스택,큐,우선순위큐,Deque(★),해시맵,문자열
    //초급) PriorityQueue 완전탐색
    //중급) BinarySearch DFS BFS Recursion
    //심화) Graph DP

    static void bfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        visited[r][c] = true;
//3
//1 1 10
//1 5 1
//2 2 -1

        //3
        //2 2 1
        //2 2 2
        //1 2 -1
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nox = poll[0];
            int noy = poll[1];
            if (map[nox][noy] == -1) {
                sb.append("HaruHaru");
                return;
            }
            for (int i = 0; i < 2; i++) {
                int nex = nox + dx[i] * map[nox][noy];
                int ney = noy + dy[i] * map[nox][noy];
                if (nex < 0 || nex >= N || ney < 0 || ney >= N) continue;
                if (visited[nex][ney]) continue;
                queue.add(new int[]{nex, ney});
                visited[nex][ney] = true;
            }
        }
        sb.append("Hing");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        map = new int[N+1][N+1];
        visited = new boolean[N+1][N+1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs(0, 0);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}