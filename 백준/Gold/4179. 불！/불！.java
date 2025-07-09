import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[] dx = {0 , 0 , 1, -1};
    static int[] dy = {1 , -1, 0 , 0};
    static boolean[][] visited;
    static char[][] map;
    static Queue<int[]> person;
    static Queue<int[]> fireWall;
    static int res;

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];
        fireWall = new LinkedList<>();
        person = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'F') fireWall.offer(new int[]{i,j});
                if (map[i][j]== 'J') {
                    person.offer(new int[]{i,j,0});
                    visited[i][j] = true;
                }
            }
        }
        bfs();
        if (res >0) {
            bw.write(res+"");
        } else {
            bw.write("IMPOSSIBLE");
        }

        bw.flush();
        bw.close();
        br.close();
    }


    static void bfs() {
        while (!person.isEmpty()) {
            int fireSize = fireWall.size();
            for (int i = 0; i < fireSize; i++) {
                int[] poll = fireWall.poll();
                int x = poll[0];
                int y = poll[1];
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                    if (map[nx][ny] == '.' || map[nx][ny] == 'J') {
                        map[nx][ny] = 'F';
                        fireWall.offer(new int[]{nx, ny});
                    }
                }
            }

            int personSize = person.size();
            for (int i = 0; i < personSize; i++) {
                int[] p = person.poll();
                int x = p[0];
                int y = p[1];
                int cnt = p[2];
                if (x == 0 || x == N - 1 || y == 0 || y == M - 1) {
                    res = cnt + 1;
                    return; // 즉시 종료
                }
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                    if (map[nx][ny] == '.' && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        person.offer(new int[]{nx, ny, cnt + 1});
                    }
                }
            }

        }
    }
}