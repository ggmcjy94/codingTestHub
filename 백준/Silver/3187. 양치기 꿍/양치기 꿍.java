import java.io.*;
import java.util.*;

public class Main {
    static int N,M,K;
    static int[] selected, arr;
    static char[][] map;
    static boolean[] used;
    static int[] dx = {0 , 1, 0, -1};
    static int[] dy = {1 , 0, -1, 0};
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();
    static int w = 0;
    static int s = 0;
    //기본) 스택,큐,우선순위큐,Deque(★),해시맵,문자열
    //초급) PriorityQueue 완전탐색
    //중급) BinarySearch DFS BFS Recursion
    //심화) Graph DP
    static void dfs (int r, int c) {
        if (map[r][c] == 'v') w++;
        if (map[r][c] == 'k') s++;
        for (int i = 0; i<4; i++) {
            int nex = dx[i] + r;
            int ney = dy[i] + c;
            if (nex < 0 || nex >= N || ney < 0 || ney >= M) continue;
            if (visited[nex][ney]) continue;
            if (map[nex][ney] == '#') continue;
            visited[nex][ney] = true;
            dfs(nex,ney);
        }

    }

    static void bfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r,c});
        visited[r][c] = true;
        int sheep = 0;
        int wolf = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nox = poll[0];
            int noy = poll[1];
            if (map[nox][noy] == 'v') wolf++;
            if (map[nox][noy] == 'k') sheep++;
            for (int i = 0; i < 4; i++) {
                int nex = dx[i] + nox;
                int ney = dy[i] + noy;
                if (nex < 0 || nex >= N || ney < 0 || ney >= M) continue;
                if (visited[nex][ney]) continue;
                if (map[nex][ney] == '#') continue;
                queue.add(new int[]{nex,ney});
                visited[nex][ney] = true;
            }
        }
        if (wolf >= sheep) w += wolf;
        if (sheep > wolf) s += sheep;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        int wolf = 0;
        int sheep = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    if (map[i][j] == 'k' || map[i][j] == 'v') {
                        w =0;
                        s = 0;
                        visited[i][j] = true;
                        dfs(i, j);
                        if (w >= s) wolf += w;
                        if (s > w) sheep += s;
                    }
                }
            }
        }
        bw.write(sheep +" "+ wolf);
        bw.flush();
        bw.close();
        br.close();
    }
}