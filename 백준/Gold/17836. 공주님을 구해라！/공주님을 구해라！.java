import java.io.*;
import java.util.*;

public class Main {

    static int N,M,T,sx,sy,res;
    static int[][] map;
    static int[][] swordMap;
    static int[][] copyMap;
    static boolean[][][] visited;
    static boolean sword;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1 ,-1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        //10
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        swordMap = new int[N][M];
        copyMap = new int[N][M];
        visited = new boolean[N][M][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        res = bfs(0,0);
        if (res == -1 || res > T) {
            bw.write("Fail");
        } else {
            bw.write(res + "");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    private static int bfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r,c,0,0});
        visited[r][c][0] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            int sword = curr[2];
            int time = curr[3];

            if (x == N - 1 && y == M - 1) {
                return time;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny][sword]) continue;

                if (sword==0 && map[nx][ny] == 1) continue;

                if (map[nx][ny] == 2) {
                    queue.add(new int[]{nx, ny, 1, time + 1}); // 검을 얻음
                    visited[nx][ny][1] = true;
                } else {
                    queue.add(new int[]{nx, ny, sword, time + 1}); // 기존 상태 유지
                    visited[nx][ny][sword] = true;
                }
            }
        }
        return -1;
    }
}