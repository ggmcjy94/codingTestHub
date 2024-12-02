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
    static boolean[][] virus;
    static boolean check;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1 , 0, -1, 0};
    static Queue<int[]> queue = new LinkedList<>();

    static void rec(int x) {
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
        copyMap = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                copyMap[i][j] = map[i][j];
                if (copyMap[i][j] == 3) {
                    queue.offer(new int[] {i , j});
                    visited[i][j] = true;
                    copyMap[i][j] = 0;
                }
                if (copyMap[i][j] == 2) {
                    copyMap[i][j] = 0;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nx = poll[0];
            int ny = poll[1];
            for (int i = 0; i < 4; i++) {
                int nex = nx + dx[i];
                int ney = ny + dy[i];
                if (nex < 0 || ney < 0 || nex >= N || ney >= N || visited[nex][ney]) continue;
                if (copyMap[nex][ney] == 0) {
                    queue.offer(new int[]{nex, ney});
                    visited[nex][ney] = true;
                    copyMap[nex][ney] += copyMap[nx][ny] + 1;
                }

            }
        }
        int a = 0;
        for (int i = 0; i < N; i++) {
//            System.out.println();
            for (int j = 0; j < N; j++) {
//                System.out.print(copyMap[i][j] +" ");
                if (virus[i][j]) {
                    if (visited[i][j]) {
                        a = Math.max(a, copyMap[i][j]);
                    } else {
                        if (copyMap[i][j] == 0) return;

                    }
                }
            }
        }
//        System.out.println();
        res = Math.min(res , a);
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
        virus = new boolean[N][N];
        res = Integer.MAX_VALUE-1;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                     virus[i][j] = true;
                }
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