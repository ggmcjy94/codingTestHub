import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N][N*N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) -'0';
            }
        }

        bfs();
        bw.write(min+"");
        bw.flush();
        bw.close();
        br.close();
    }

    //8
    //11100110
    //11010010
    //10011010
    //11101100
    //01000111
    //00110001
    //11011000
    //11000111
    //2
    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0,0,0});
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nx = poll[0];
            int ny = poll[1];
            int mv = poll[2];
            int toWhite = poll[3];
            if (min < toWhite) continue;
            if (nx == N-1 && ny == N-1) {
                if (min > toWhite) {
                    min = toWhite;
                }
                continue;
            }
            for (int i = 0; i < 4; i++) {
                int nex = nx + dx[i];
                int ney = ny + dy[i];

                if (nex < 0 || ney < 0 || nex >= N || ney >= N || visited[nex][ney][toWhite]) continue;

                if (map[nex][ney] == 1) {
                    visited[nex][ney][toWhite] = true;
                    queue.offer(new int[]{nex,ney,mv+1,toWhite});
                }

                if (map[nex][ney] == 0) {
                    visited[nex][ney][toWhite] = true;
                    queue.offer(new int[]{nex,ney,mv+1,toWhite+1});
                }
            }
        }

    }
}