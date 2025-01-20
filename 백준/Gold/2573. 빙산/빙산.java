import java.io.*;
import java.util.*;

public class Main {

    static int N , M;
    static int[][] map;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    
    private static void dfs(int r, int c, boolean[][] visited) {
        visited[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int nx = r + dx[i];
            int ny = c + dy[i];
            if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny]  ) continue;
            if (map[nx][ny] > 0) {
                dfs(nx, ny , visited);
            }
        }

    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] bfsVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) {
                    queue.offer(new int[]{i,j});
                    bfsVisited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nox = poll[0];
            int noy = poll[1];
            for (int i = 0; i < 4; i++) {
                int nx = nox + dx[i];
                int ny = noy + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M || bfsVisited[nx][ny]  ) continue;
                if (map[nx][ny] == 0) {
                    if (map[nox][noy] > 0) {
                        map[nox][noy] -= 1;
                    }
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int y = 0;
        while (true) {
            boolean[][] dfsVisited = new boolean[N][M];
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!dfsVisited[i][j] && map[i][j] > 0) {
                        dfs(i, j, dfsVisited);
                        cnt++;
                    }
                }
            }
            if (cnt >= 2) {
                break;
            } else if (cnt == 0) {
                y = 0;
                break;
            }
            bfs();
            y++;
        }
        bw.write(y+"");
        bw.flush();
        bw.close();
        br.close();
    }
}