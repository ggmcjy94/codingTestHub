import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br;
    static BufferedWriter bw;
    static int N ,M,H;
    static int R ,C;
    static int[][] arr;
    static int[][][] t_arr;
    static boolean[][] visited;
    static boolean[][][] t_visited;

    static int[] dx = {1,0,-1,0,0,0};
    static int[] dy = {0,1,0,-1,0,0};
    static int[] dh = {0,0,0,0,1,-1};


    static int res = Integer.MIN_VALUE;
    static Queue<Point> queue = new LinkedList<>();
    private static int bfs() {
        //5 3 2
        //0 0 0 0 0
        //0 0 0 0 0
        //0 0 0 0 0

        //0 0 0 0 0
        //0 0 1 0 0
        //0 0 0 0 0
        //4
        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            int h = poll.h;
            int r = poll.r;
            int c = poll.c;

            for (int i = 0; i < 6; i++) {
                int neh = h + dh[i];
                int nex = r + dx[i];
                int ney = c + dy[i];
                if (neh < 0 || neh >= H || nex  < 0 || nex >= N || ney < 0 || ney >= M) continue;
                if (t_arr[neh][nex][ney] == 0) {
                    queue.add(new Point(neh,nex,ney));
                    t_arr[neh][nex][ney] = t_arr[h][r][c] +1;
                }
            }
        }

        for (int i = 0; i<H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (t_arr[i][j][k] == 0) return -1;
                    res = Math.max(res, t_arr[i][j][k]);
                }
            }
        }
        return res;
    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine()," ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        t_arr = new int[H][N][M];


        for (int i = 0; i < H; i++) {
            for (int j =0 ; j<N; j++) {
                st = new StringTokenizer(br.readLine()," ");
                for (int k = 0; k<M;k++) {
                    t_arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if(t_arr[i][j][k] == 1) queue.add(new Point(i, j ,k));
                }
            }
        }
        int result = bfs();
        if (result == 1) {
            bw.write("0");
        } else if (result == -1){
            bw.write("-1");
        } else {
            bw.write(result-1 +"");
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