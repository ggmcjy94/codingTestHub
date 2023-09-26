import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br;
    static BufferedWriter bw;
    static int[][] arr;
    static boolean[][] visited;
    static int[][] result;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int N,M,K,X,r,g,b,res;
    static int max = Integer.MIN_VALUE;
    static int min_count = 0;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static List<Integer> arr2 = new ArrayList<>();

    static void bfs(int x, int y) throws IOException {
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int now_x = poll[0];
            int now_y = poll[1];
            for (int i = 0; i < 4; i++) {
                int next_x = now_x + dx[i];
                int next_y = now_y + dy[i];
                if (next_x < 0 || next_x >= N || next_y < 0 || next_y >= M) continue;
                if (arr[next_x][next_y] == 1 && !visited[next_x][next_y]) {
                    queue.add(new int[]{next_x, next_y});
                    visited[next_x][next_y] = true;
                    result[next_x][next_y] = result[now_x][now_y]+1;
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
        arr = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        result = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j<M; j++) {
                if (arr[i][j] == 2) {
                    result[i][j] = 0;
                    bfs(i, j);
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && arr[i][j] == 1) {
                    result[i][j] = -1;
                }
                bw.write(result[i][j] + " ");
            }
            bw.write("\n");
        }
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
//1 1 1 1 1 1 1 1 1 1 0 0 0 0 0
//1 1 1 1 1 1 1 1 1 1 0 1 1 1 1
//1 1 1 1 1 1 1 1 1 1 0 1 0 0 0
//1 1 1 1 1 1 1 1 1 1 0 1 1 1 1

        bw.flush();
        bw.close();
    }
//    static class Node {
//        int x, y;
//
//        public Node(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }
}
