import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {

    static int N,L,R,M, C,K;
    static int destination,distance,res;
    static int[][] map;
    static int[][] copyMap;
    static boolean[][] visited;
    static boolean[][] checkVisit;
    static boolean check;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1 , 0, -1, 0};
    static Queue<int[]> queue = new LinkedList<>();

    static void rec(int x) {
//        System.out.println(x);
        if (x == M) {
            bfs();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 2) {
                    map[i][j] = 3;
                    rec(x+1);
                    map[i][j] = 2;
                }
            }
        }
    }

    static void bfs() {

        queue = new LinkedList<>();
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 3) {
                    queue.offer(new int[] {i , j});
                    visited[i][j] = true;
                }
            }
        }

        copyMap = new int[N][N];

        for (int i = 0; i < N; i++) {
            copyMap[i] = map[i].clone();
        }

        //6 3
        //2 1 2 0 1 1
        //0 0 0 1 0 1
        //1 1 0 0 2 0
        //1 0 0 1 0 1
        //1 0 0 0 0 1
        //1 1 2 1 0 1
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nx = poll[0];
            int ny = poll[1];
//            System.out.println(nx + " : "+ ny);
            for (int i = 0; i < 4; i++) {
                int nex = nx + dx[i];
                int ney = ny + dy[i];
                if (nex < 0 || ney < 0 || nex >= N || ney >= N ||  visited[nex][ney]) continue;
                if (copyMap[nex][ney] == 0) {
                    queue.offer(new int[]{nex, ney});
                    visited[nex][ney] = true;
                    copyMap[nex][ney] += copyMap[nx][ny] + 1;
                }

            }
        }
        //2 1 2 0 1 1
        //3 4 5 1 0 1
        //1 1 6 7 2 0
        //1 8 7 1 11 1
        //1 9 8 9 10 1
        //1 1 2 1 11 1
        int a = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (copyMap[i][j] == 0) {
                    res = -1;
                    return;
                }
                if (visited[i][j]) {
                   a = Math.max(a, copyMap[i][j]);
                }
            }
        }

        res = Math.min(res , a-3);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        checkVisit = new boolean[N][N];
        res = Integer.MAX_VALUE-1;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        rec(0);

        if (res == Integer.MAX_VALUE-1) {
            bw.write("-1");
        } else {
            bw.write(res+"");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}