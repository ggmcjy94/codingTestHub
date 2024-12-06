import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {

    static int N , M, S;
    static int [][] map;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static boolean[][] visited;

    //4 6
    //1 0 1 1 1 1
    //1 0 1 0 1 0
    //1 0 1 0 1 1
    //1 1 1 0 1 1

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[N+1][M+1];
        queue.add(new int[]{x,y});
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nox = poll[0];
            int noy = poll[1];
            for (int i = 0; i < 4; i++) {
                int nex = nox + dx[i];
                int ney = noy + dy[i];
                if (nex <= 0 || ney <= 0 || nex > N || ney > M || visited[nex][ney]) continue;
                if (map[nex][ney] == 1) {
                    queue.offer(new int[]{nex,ney});
                    visited[nex][ney] = true;
                    map[nex][ney] += map[nox][noy];
                }

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
        map = new int[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs(1,1);

        if (!visited[N][M]) {
            bw.write("0");
        } else {
            bw.write(map[N][M]+"");
        }

        bw.flush();
        bw.close();
        br.close();

    }

}