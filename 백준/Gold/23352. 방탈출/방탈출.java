import java.io.*;
import java.util.*;

public class Main {

    static int N , M, res, initVal,len, max ;
    static int[][] map;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

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


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0) {
                    bfs(i, j);
                }
            }
        }
        bw.write(max+"");
        br.close();
        bw.flush();
        bw.close();
    }

    private static void bfs(int x, int y) {
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y, 0});
        visited[x][y] = true;
        int start = map[x][y];


        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nx = poll[0];
            int ny = poll[1];
            int dis = poll[2];
            boolean flag = false;
            for (int i = 0; i < 4; i++) {
                int nex = nx + dx[i];
                int ney = ny + dy[i];
                if (nex < 0 || ney < 0 || nex >= N || ney >= M  || map[nex][ney] == 0 || visited[nex][ney]) continue;
                flag = true;
                visited[nex][ney] = true;
                queue.offer(new int[]{nex,ney,dis + 1});
            }

            if (!flag && dis >= len) {
                if (dis>len) {
                    max = start + map[nx][ny];
                } else {
                    max = Math.max(max, start + map[nx][ny]);
                }
                len = dis;
            }
        }
    }
}