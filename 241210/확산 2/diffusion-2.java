import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {

    static int N , M, S;
    static int [][] map;
    static int[] arr;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static boolean[][] visited;
    static boolean[] visit;
    static int res;
    static Queue<int[]> queue = new LinkedList<>();
    static boolean zeroCheck;
//4 6
//1 -1 0 0 0 0
//0 -1 0 0 0 0
//0 0 0 0 -1 0
//0 0 0 0 -1 1

    //6

    static void bfs() {

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nox = poll[0];
            int noy = poll[1];

            for (int i = 0; i < 4; i++) {
                int nex = nox + dx[i];
                int ney = noy + dy[i];
                if (nex < 0|| ney < 0 || nex>=N || ney>=M || visited[nex][ney]) continue;
                if (map[nex][ney] == 0) {
                    queue.offer(new int[]{nex,ney});
                    visited[nex][ney] = true;
                    map[nex][ney] = map[nox][noy]+1;
                }
            }
        }
        for (int[] ints : map) {
            for (int anInt : ints) {
                if (anInt == 0) {
                    zeroCheck = true;
                    res = 0;
                    return;
                }
                res = Math.max(res , anInt);
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
            for (int j = 0; j< M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        bfs();
        bw.write(res-1+"");
        bw.flush();
        bw.close();
        br.close();

    }

}