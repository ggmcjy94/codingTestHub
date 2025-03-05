import java.io.*;
import java.util.*;

public class Main {

    static int N,M, K;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx= {0,-1,0,  1, 1,-1,-1};
    static int[] dy ={-1,0,1, 1,-1,1,-1};
    static Queue<int[]> queue = new LinkedList<>();
    static int res;
    //3
    //#.#
    //.#.
    //.#F
    // F 에서 갈수 있는 체크
    static void bfs () {

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nx = poll[0];
            int ny = poll[1];
            if (map[nx][ny]  == '.') {
                res++;
            }
            for (int i = 0; i < 7; i++) {
                int nex = nx + dx[i];
                int ney = ny + dy[i];
                if (nex < 0 || ney < 0 || nex >= N || ney >=  N || visited[nex][ney]) continue;
                if (map[nex][ney] =='.') {
                    queue.offer(new int[]{nex,ney});
                    visited[nex][ney] = true;
                }

            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        visited = new boolean[N][N];
        res = 0;
        for (int i = 0; i < N ; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'F') {
                    queue.offer(new int[]{i,j});
                    visited[i][j] = true;
                }

            }
        }

        bfs();
        bw.write(res+"");
        bw.flush();
        bw.close();
        br.close();
    }


}