import org.omg.CORBA.OMGVMCID;

import java.io.*;
import java.util.*;

public class Main {

    static int N , M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1 , -1 , 0 , 0};
    static int[] dy = {0 , 0 , 1, -1};
    static Queue<int[]> queue = new LinkedList<>();
    //15 15
    //2 1 1 1 1 1 1 1 1 1 1 1 1 1 1
    //1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
    //1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
    //1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
    //1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
    //1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
    //1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
    //1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
    //1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
    //1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
    //1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
    //1 1 1 1 1 1 1 1 1 1 0 0 0 0 1
    //1 1 1 1 1 1 1 1 1 1 0 1 1 1 1
    //1 1 1 1 1 1 1 1 1 1 0 1 0 0 0
    //1 1 1 1 1 1 1 1 1 1 0 1 1 1 1

    static void bfs() {

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nox = poll[0];
            int noy = poll[1];
            for (int i = 0; i < 4; i++) {
                int nex = nox + dx[i];
                int ney = noy + dy[i];
                if (nex < 0 || ney < 0 || nex >= N || ney >= M || visited[nex][ney] || map[nex][ney] == 0) continue;
                queue.offer(new int[]{nex,ney});
                visited[nex][ney] = true;
                map[nex][ney] += map[nox][noy];
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
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    visited[i][j] = true;
                    map[i][j] = 0;
                    queue.add(new int[]{i,j});
                }
            }
        }
        bfs();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    System.out.print("-1 ");
                } else {
                    System.out.print(map[i][j] + " ");
                }

            }
            System.out.println();
        }

        bw.flush();
        bw.close();
        br.close();
    }

}