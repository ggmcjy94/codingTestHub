import java.io.*;
import java.util.*;

public class Main {
    static int N, M, cnt;
    static char[][] map;
    static Queue<int[]> queue;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static boolean[][] visited;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();


        while (true) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) break;
            map = new char[N][M];
            visited = new boolean[N][M];
            queue = new LinkedList<>();
            cnt = 0;
            for (int i = 0; i < N; i++) {
                String a = br.readLine();
                for (int j = 0; j < M; j++) {
                    map[i][j] = a.charAt(j);
                    if (map[i][j] == '@') {
                        queue.offer(new int[]{i, j});
                        visited[i][j] = true;
                        cnt++;
                    }
                }
            }
            bfs();
            sb.append(cnt).append('\n');

        }
        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();

    }
    static void bfs () {
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nx = poll[0];
            int ny = poll[1];
            for (int i = 0; i < 4; i++) {
                int nex = nx + dx[i];
                int ney = ny + dy[i];
                if (nex < 0 || ney < 0 || nex >= N || ney >= M || visited[nex][ney]) continue;
                if (map[nex][ney] == '.') {
                    queue.offer(new int[]{nex, ney});
                    visited[nex][ney] = true;
                    cnt++;
                }
            }
        }
    }
}