import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] map;
    static boolean[][] checkVisited;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        res = 0;
        while (true) {
            checkVisited = new boolean[N][M];
            extBfs(0, 0); 

            List<int[]> meltList = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1 && willMelt(i, j)) {
                        meltList.add(new int[]{i, j});
                    }
                }
            }

            if (meltList.isEmpty()) break; 

            for (int[] pos : meltList) {
                map[pos[0]][pos[1]] = 0;
            }
            res++;
        }

        bw.write(res + "");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void extBfs(int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        checkVisited[r][c] = true;
        map[r][c] = 2; 

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M || checkVisited[nx][ny] || map[nx][ny] == 1) continue;
                map[nx][ny] = 2; 
                checkVisited[nx][ny] = true;
                queue.offer(new int[]{nx, ny});
            }
        }
    }

    private static boolean willMelt(int r, int c) {
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int nx = r + dx[i];
            int ny = c + dy[i];
            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if (map[nx][ny] == 2) cnt++; 
        }
        return cnt >= 2;
    }
}