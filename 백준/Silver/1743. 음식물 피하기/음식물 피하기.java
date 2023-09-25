
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
    static int N,M,K,r,g,b;
    static int max = Integer.MIN_VALUE;
    static int min_count = 0;
//5
//RRRBB
//GGBBB
//BBBRR
//BBRRR
//RRRRR
// 적록색약이 아닌 사람이 봤을 때 구역의 수는 총 4개이다. (빨강 2, 파랑 1, 초록 1)
// 하지만, 적록색약인 사람은 구역을 3개 볼 수 있다. (빨강-초록 2, 파랑 1)
    static void bfs(int r , int c) {
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[]{r, c});
        visited[r][c] = true;
        min_count = 1;
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int now_x = temp[0];
            int now_y = temp[1];

            for (int i =0; i < 4; i++) {
                int next_x = now_x + dx[i];
                int next_y = now_y + dy[i];
                if (next_x <= 0 || next_x > N || next_y <= 0 || next_y > M) continue;
                if (arr[next_x][next_y] == 1 && !visited[next_x][next_y]) {
                    queue.add(new int[]{next_x, next_y});
                    visited[next_x][next_y] = true;
                    min_count++;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N+1][M+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j<=M; j++) {
                arr[i][j] = 0;
            }
        }
        for (int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[r][c] = 1;
        }
        visited = new boolean[N+1][M+1];
        for (int i = 1; i<=N; i++) {
            for (int j =1; j <= M; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                    max = Math.max(max, min_count);
                }
            }
        }

        //3 4 5
        //3 2
        //2 2
        //3 1
        //2 3
        //1 1
        bw.write(max+"");
        bw.flush();
        bw.close();
    }

    static class Node{
        int x , t;

        public Node(int x, int t) {
            this.x = x;
            this.t = t;
        }
    }
}
