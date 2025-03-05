import java.io.*;
import java.util.*;

public class Main {

    static int N,M, K;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx= {0,0,1,-1};
    static int[] dy ={1,-1,0,0};
    //2 3 2
    //5 4 6
    //4 7 2
    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});
        visited[x][y] =true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nox = poll[0];
            int noy = poll[1];
            for (int i = 0; i < 4; i++) {
                int nx = nox + dx[i];
                int ny = noy + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny]) continue;
                int abs = Math.abs(map[nox][noy] - map[nx][ny]);
                if (abs <= K) {
                    queue.offer(new int[]{nx,ny});
                    visited[nx][ny] = true;
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
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt =0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                    cnt++;
                }
            }
        }
        bw.write(cnt+"");
        bw.flush();
        bw.close();
        br.close();
    }


}