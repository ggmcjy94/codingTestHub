import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {

    static int N , M, S;
    static char[][] map;
    static char[][] fullMap;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static boolean[][] visited;


    //6 7 3
    //.......
    //...O...
    //....O..
    //.......
    //OO.....
    //OO.....

    static void bfs() {
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nox = poll[0];
            int noy = poll[1];
            map[nox][noy] = '.';
            for (int i = 0; i < 4; i++) {
                int nex = nox + dx[i];
                int ney = noy + dy[i];
                if (nex < 0 || ney < 0 || nex >= N || ney >= M|| visited[nex][ney]) continue;
                map[nex][ney] = '.';
                visited[nex][ney] = true;
            }
        }
        visited = new boolean[N][M];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        visited = new boolean[N][M];
        map = new char[N][M];
        fullMap = new char[N][M];
        for (int i = 0; i < N ; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
                fullMap[i][j] = 'O';
                if (map[i][j] == 'O') {
                    queue.offer(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }

        for (int i = 2; i <= S; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < N; j++) {
                    map[j] = fullMap[j].clone();
                }
            } else {
                bfs();

                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < N; k ++) {
                        if (map[j][k] =='O') {
                            queue.offer(new int[]{j, k});
                            visited[j][k] = true;
                        }

                    }
                }
            }
        }
        for (char[] chars : map) {
            for (char aChar : chars) {
                bw.write(aChar);
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}