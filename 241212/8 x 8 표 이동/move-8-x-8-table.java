import java.io.*;
import java.util.*;

public class Main {

    static int N , M, S;
    static char [][] map;
    static int[][] arr;
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    static List<int[]> wallList = new ArrayList<>();
    static boolean[][] meetList;
    static boolean[][] visited;
    static boolean[] visit;
    static Queue<int[]> queue = new LinkedList<>();



    static int bfs(int x, int y) {
        visited[x][y] = true;
        queue.add(new int[]{x,y});
        while (!queue.isEmpty()) {

            int[] poll = queue.poll();
            int nox = poll[0];
            int noy = poll[1];

            if (map[nox][noy] == '#') continue;

            if (nox == 0 && noy == 7) {
                return 1;
            }

            for (int i = 0; i < 8; i++) {
                int nex = nox + dx[i];
                int ney = noy + dy[i];
                if (nex < 0 || ney < 0 || nex>=N || ney >= M || visited[nex][ney]) continue;
                if (map[nex][ney] == '.') {
                    queue.offer(new int[]{nex, ney});
                    visited[nex][ney] = true;
                }
            }
            moveWalls();
        }
        return 0;
    }
    static void moveWalls() {
        for (int i = 7; i > 0; i--) {
            map[i] = Arrays.copyOf(map[i-1],8);
        }
        Arrays.fill(map[0], '.');
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = 8;
        M = 8;
        map = new char[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        bw.write(bfs(N-1, 0)+"");
        bw.flush();
        bw.close();
        br.close();
    }

}