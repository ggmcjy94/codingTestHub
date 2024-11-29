import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {

    static int N,L,R,M, C,K;
    static int destination,distance,res;
    static int[][] map;
    static int[][] copyMap;
    static boolean[][] visited;
    static boolean check;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1 , 0, -1, 0};
    static Queue<int[]> queue;

    static void dfs (int x) {

        if (x == 3) {
            bfs();
            return;
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(x + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static void bfs () {
        queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) queue.offer(new int[]{i, j});
            }
        }
        copyMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            copyMap[i] = map[i].clone();
        }

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nox = poll[0];
            int noy = poll[1];
            for (int i = 0; i < 4; i++) {
                int nx = nox + dx[i];
                int ny = noy + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny>=M) continue;
                if (copyMap[nx][ny] == 0) {
                    copyMap[nx][ny] = 2;
                    queue.offer(new int[]{nx,ny});
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0) {
                    cnt++;
                }
            }
        }
        res = Math.max(res, cnt);
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
        dfs(0);
        bw.write(res+"");
        bw.flush();
        bw.close();
        br.close();
    }

}