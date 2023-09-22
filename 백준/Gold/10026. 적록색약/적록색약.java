import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br;
    static BufferedWriter bw;
    static int[][] arr;
    static boolean[][] visited;
    static int[] result;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int N,M,r,g,b;
    static int min_count = Integer.MAX_VALUE;
//5
//RRRBB
//GGBBB
//BBBRR
//BBRRR
//RRRRR
// 적록색약이 아닌 사람이 봤을 때 구역의 수는 총 4개이다. (빨강 2, 파랑 1, 초록 1)
// 하지만, 적록색약인 사람은 구역을 3개 볼 수 있다. (빨강-초록 2, 파랑 1)
    static void bfs(int x, int y, char target, boolean c) {
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int now_x = poll[0];
            int now_y = poll[1];
            for (int i = 0; i < 4; i++) {
                int nx = now_x + dx[i];
                int ny = now_y + dy[i];
                if (nx < 0 || nx >=N || ny < 0 || ny >= N) continue;
                if (c) {
                    if (arr[nx][ny] != 'B' && !visited[nx][ny]) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                } else {
                    if (arr[nx][ny] == target && !visited[nx][ny]) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }

            }
        }
    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i<N; i++) {
            String s = br.readLine();
            for (int j = 0; j<N; j++) {
                arr[i][j] = s.charAt(j);
            }
        }
        int sum = 0;
        visited = new boolean[N][N];
        for (int i = 0; i<N; i++) {
            for (int j = 0; j<N; j++) {
                if (arr[i][j] == 'R' && !visited[i][j]) {
                    bfs(i, j,'R', false);
                    r++;
                }
                if (arr[i][j] == 'G' && !visited[i][j]) {
                    bfs(i, j,'G',false);
                    g++;
                }
                if (arr[i][j] == 'B' && !visited[i][j]) {
                    bfs(i, j,'B',false);
                    b++;
                }
            }
        }
        sum += r+g+b;
        bw.write(sum+" ");
        sum = 0;
        r = 0;
        b = 0;
        visited = new boolean[N][N];
        for (int i = 0; i<N; i++) {
            for (int j = 0; j<N; j++) {
                if (arr[i][j] != 'B' && !visited[i][j]) {
                    bfs(i, j,'R', true);
                    r++;
                }
                if (arr[i][j] == 'B' && !visited[i][j]) {
                    bfs(i, j,'B',false);
                    b++;
                }
            }
        }
        sum += r+b;
        bw.write(sum+"");
        bw.flush();
        bw.close();
    }
}