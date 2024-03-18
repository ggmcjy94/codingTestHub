import java.io.*;
import java.util.*;

public class Main {

    static int N,M,C,T,A,B;
    static int ans;
    static StringTokenizer st;
    static int[] dx = {1,0,-1,0,1,-1,-1,1};
    static int[] dy = {0,1,0,-1,1,1,-1,-1};
    static int[][] arr, brr;
    static Queue<int[]> queue;
    static boolean[][] visited;

    static void bfs() {
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nox = poll[0];
            int noy = poll[1];
            for (int i = 0; i < 8; i++) {
                int nex = nox + dx[i];
                int ney = noy + dy[i];
                if (nex < 0 || ney < 0 || nex >= N || ney >=M) continue;
                if (brr[nex][ney] != 0 || arr[nex][ney] == 1) continue;
                brr[nex][ney] = brr[nox][noy] + 1;
                if (brr[nex][ney] > ans) ans = brr[nex][ney];
                queue.add(new int[]{nex,ney});
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        brr = new int[N][M];
        queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int val = Integer.parseInt(st.nextToken());
                arr[i][j] = val;
                if (val == 1) {
                    queue.add(new int[]{i,j});
                }

            }
        }
        ans = Integer.MIN_VALUE;
        bfs();
        bw.write(ans+"");
        bw.flush();
        bw.close();
        br.close();
    }

}

