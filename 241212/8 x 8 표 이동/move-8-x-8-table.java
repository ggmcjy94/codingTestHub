import java.io.*;
import java.util.*;

public class Main {

    static int N , M, S;
    static char [][] map;
    static int[][] arr;
    static int[] dx = {0,1,0,-1,1,-1,-1,1};
    static int[] dy = {1,0,-1,0,1,-1,1,-1};
    static List<int[]> wallList = new ArrayList<>();
    static boolean[][] meetList;
    static boolean[][] visited;
    static boolean[] visit;
    static Queue<int[]> queue = new LinkedList<>();



    static void bfs(int x, int y) {
        visited[x][y] = true;
        queue.add(new int[]{x,y});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            moveWalls();
            int nox = poll[0];
            int noy = poll[1];
            for (int i = 0; i < 8; i++) {
                int nex = nox + dx[i];
                int ney = noy + dy[i];
                if (nex < 0 || ney < 0 || nex>=N || ney >= M || visited[nex][ney]) continue;
                if (map[nex][ney] == '.') {
                    queue.offer(new int[]{nex, ney});
                    visited[nex][ney] = true;
                }
            }
        }
    }
    static void moveWalls() {
        for (int i = wallList.size()-1; i >= 0; i--) {
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

        if (map[N-1][0] == '#') {
            System.out.print("0");
            return;
        }
        bfs(N-1, 0);

        if (visited[0][M-1]) {
            bw.write("1");
        } else {
            bw.write("0");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}