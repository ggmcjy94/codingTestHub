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
            int size = queue.size();
            moveWalls();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int nox = curr[0];
                int noy = curr[1];
                if (nox == 0 && noy == 7) {
                    return 1;
                }
                for (int j = 0; j < 8; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if (nx >= 0 && nx < 8 && ny >= 0 && ny < 8 && !visited[nx][ny] && map[nx][ny] == '.') {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        return 0;
    }
    static void moveWalls() {
        for (int i = wallList.size()-1; i > 0; i--) {
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