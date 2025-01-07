import java.io.*;
import java.util.*;

public class Main {

    static int N , M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int cnt;
    static int res;

    static void bfs () {
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
            int x = poll[0];
            int y = poll[1];
            for (int i = 0; i < 4; i++)  {
                int nex = x + dx[i];
                int ney = y + dy[i];
                if (nex < 0 || ney < 0 || nex >= N || ney >= M || bfsVisited[nex][ney]) continue;
                if (map[nex][ney] == 0) {
                    if (map[x][y] > 0) {
                        map[x][y] -= 1;
                    }
                }
            }
        }
    }


    static void dfs (int r, int c , boolean[][] visited) {
        visited[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int nex = r + dx[i];
            int ney = c + dy[i];
            if (nex < 0 || ney < 0 || nex >= N || ney >=M || visited[nex][ney]) continue;
            if (map[nex][ney] > 0) {
                dfs(nex,ney, visited);
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
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //5 7
        //0 0 0 0 0 0 0
        //0 2 4 5 3 0 0
        //0 3 0 2 5 2 0
        //0 7 6 2 4 0 0
        //0 0 0 0 0 0 0

        //0 0 0 0 0 0 0
        //0 0 2 4 1 0 0
        //0 1 0 1 5 0 0
        //0 5 4 1 2 0 0
        //0 0 0 0 0 0 0

        //0 0 0 0 0 0 0
        //0 0 0 3 0 0 0
        //0 0 0 0 4 0 0
        //0 3 2 0 0 0 0
        //0 0 0 0 0 0 0
        int y = 0;
        while (true) {
            boolean[][] dfsVisited = new boolean[N][M];
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (!dfsVisited[i][j] && map[i][j] > 0) {
                        dfs(i , j , dfsVisited);
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