import java.io.*;
import java.util.*;

public class Main {

    static int N,M;
    static int[][] map;
    static Queue<int[]> birus;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int cnt,res;


    static void dfs (int x) {
        if (x == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(x+1);
                    map[i][j] = 0;
                }
            }
        }
    }


    static void bfs () {
        birus = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) {
                    birus.offer(new int[]{i,j});
                }
            }
        }

        int[][] copyMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            copyMap[i] = map[i].clone();
        }
        cnt = 0;
        while(!birus.isEmpty()) {
            int[] poll = birus.poll();
            int x = poll[0];
            int y = poll[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny>=M) continue;
                if (copyMap[nx][ny] == 0) {
                    birus.offer(new int[] {nx,ny});
                    copyMap[nx][ny] = 2;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0) {
                    cnt++;
                }
            }
        }
        res = Math.max(cnt, res);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        birus = new LinkedList<>();
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