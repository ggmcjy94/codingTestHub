import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {

    static int N,L,R,M, C,K;
    static int destination,distance,cnt;
    static int[][] map;
    static int[][] copyMap;
    static boolean[][] visited;
    static boolean check;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1 , 0, -1, 0};
    static  List<Pos> list;

    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void bfs (int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r,c});
        list = new ArrayList<>();
        visited[r][c] = true;
        list.add(new Pos(r, c));
        int sum = map[r][c];
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nox = poll[0];
            int noy = poll[1];
            for (int i = 0; i < 4; i++) {
                int nex = dx[i] + nox;
                int ney = dy[i] + noy;
                if (nex < 0 || ney<0 || nex >= N || ney >= N) continue;
                if (visited[nex][ney]) continue;
                int abs = Math.abs(map[nox][noy] - map[nex][ney]);
                if (abs >= L && abs <=R) {
                    queue.offer(new int[]{nex, ney});
                    visited[nex][ney] = true;
                    list.add(new Pos(nex, ney));
                    sum += map[nex][ney];
                    check = true;
                }
            }
        }
        if (list.size() > 1) {
            int chVal = sum / list.size();
            for (Pos pos : list) {
                map[pos.x][pos.y] = chVal;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt= 0;
        while (true) {
            visited = new boolean[N][N];
            check = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        bfs(i , j);
                    }
                }
            }
            if (check) {
                cnt++;
            } else {
                break;
            }
        }
        bw.write(cnt+"");
        bw.flush();
        bw.close();
        br.close();
    }

}