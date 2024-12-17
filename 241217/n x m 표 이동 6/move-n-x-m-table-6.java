import java.io.*;
import java.util.*;

public class Main {

    static int N , M, T;
    static int[][] map;
    static int[][] copyMap;
    static int[] arr, maxCopy, minCopy;
    static boolean meet;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> queue2 = new LinkedList<>();
    static boolean[][] visited1;
    static boolean[][] visited2;

    //1
    //2

    static void bfs(int x , int y) {
        visited1 = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited1[x][y] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nox = poll[0];
            int noy = poll[1];
            if (map[nox][noy] == 2) {
                meet = true;
            }
            for (int i = 0; i < 4; i++) {
                int nex = nox + dx[i];
                int ney = noy + dy[i];
                if (nex < 0 || ney < 0 || nex>=N || ney>=M || visited1[nex][ney] || map[nex][ney] == 1) continue;
                visited1[nex][ney] = true;
                queue.offer(new int[]{nex,ney});
                copyMap[nex][ney] = copyMap[nox][noy] + 1;
            }
        }
    }

    static void bfs2() {
        while (!queue2.isEmpty()) {
            int[] poll = queue2.poll();
            int nox = poll[0];
            int noy = poll[1];
            for (int i = 0; i < 4; i++) {
                int nex = nox + dx[i];
                int ney = noy + dy[i];
                if (nex < 0 || ney < 0 || nex>=N || ney>=M || visited2[nex][ney]) continue;
                queue2.offer(new int[]{nex,ney});
                visited2[nex][ney] = true;
                copyMap[nex][ney] = copyMap[nox][noy] + 1;
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        //6 6 16
        //0 0 0 0 1 1
        //0 0 0 0 0 2
        //1 1 1 0 1 0
        //0 0 0 0 0 0
        //0 1 1 1 1 1
        //0 0 0 0 0 0

        //10
        st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        copyMap = new int[N][M];
        visited2 = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    queue2.add(new int[]{i , j});
                    visited2[i][j] = true;
                }
            }
        }

        bfs(0, 0);
        int ans = copyMap[N-1][M-1];
        if (meet) {
            copyMap = new int[N][M];
            bfs2();
            int ans2 = copyMap[0][0] + copyMap[N-1][M-1];
            ans = Math.min(ans,ans2);
        }


        if (ans == 0 || ans > T) {
            bw.write("Fail");
        } else {
            bw.write(ans+"");
        }
//        copyMap = new int[N][M];
        bw.flush();
        bw.close();
        br.close();
    }

}