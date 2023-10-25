import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br;
    static BufferedWriter bw;
    static int T, N ,M,H;
    static int R ,C;
    static int[][] arr;
    static char[][] s_arr;
    static int[][][] t_arr;
    static boolean[][] visited;
    static boolean[][][] t_visited;
    static int cnt1, cnt2;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    static int[] dx2 = {1,0,-1,0,0,0};
    static int[] dy2 = {0,1,0,-1,0,0};
    static int[] dh2 = {0,0,0,0,1,-1};


    static int res = Integer.MIN_VALUE;
//    static Queue<Point> queue = new LinkedList<>();
    //2
    //4 4
    //#.#.
    //.#.#
    //#.##
    //.#.#
    //3 5
    //###.#
    //..#..
    //#.###
    private static void bfs(int x , int y) {
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y] =true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nox = poll[0];
            int noy = poll[1];
            for (int i = 0; i<4; i++) {
                int nex = nox + dx[i];
                int ney = noy + dy[i];
                if (nex < 0 || nex >= N || ney < 0 || ney>=M) continue;
                if (s_arr[nex][ney] == '#' && !visited[nex][ney]) {
                    queue.add(new int[]{nex,ney});
                    visited[nex][ney] = true;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int q = 0; q < T; q++) {
            st = new StringTokenizer(br.readLine(),  " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            s_arr = new char[N][M];
            visited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                String reads = br.readLine();
                for (int j = 0; j < M; j++) {
                    s_arr[i][j] = reads.charAt(j);
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (s_arr[i][j] == '#' && !visited[i][j]) {
                        bfs(i, j);
                        cnt1++;
                    }
                }
            }
            bw.write(cnt1+"\n");
            cnt1=0;
        }
        bw.flush();
        bw.close();
    }


    static class Point{
        int h,r,c;

        public Point(int h, int r, int c) {
            this.h = h;
            this.r = r;
            this.c = c;
        }
    }


}