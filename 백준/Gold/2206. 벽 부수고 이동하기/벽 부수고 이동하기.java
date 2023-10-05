import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br;
    static BufferedWriter bw;
    static int[][] arr;
    static int[][] arrRes;
    static char[][] str_arr;
    static boolean[][][] visited;
    static int[][] result;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int N,M,K,X,r,g,b,res;
    static int max = Integer.MIN_VALUE;
    static int min_count = 0;
    static int w_cnt,b_cnt,w_res, b_res;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static List<Integer> arr2 = new ArrayList<>();
    static int maxHeight=0;
    private static class Node {
        private int x;
        private int y;
        private int count;
        private int wall; //벽을 부시면서 왔는지 아닌지. 0이면 아니고 1이면 벽을 부시면서 왔다는 것을 의미한다.

        public Node(int x, int y, int count, int wall) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.wall = wall;
        }
    }
    static int bfs(int x, int y) {
        Queue<Node> queue  =new LinkedList<>();
        queue.add(new Node(x,y,1,0));
        visited[x][y][0] = true;
        visited[x][y][1] = true;
        while (!queue.isEmpty()) {
            Node cu = queue.poll();
            if (cu.x == N - 1 && cu.y == M - 1) return cu.count;

            for (int i = 0; i < 4; i++) {
                int nex = cu.x + dx[i];
                int ney = cu.y + dy[i];

                if (nex < 0 || nex>=N || ney <0 || ney>=M) continue;

                if (arr[nex][ney] == 0) {
                    if (!visited[nex][ney][cu.wall]) {
                        queue.add(new Node(nex, ney, cu.count+1, cu.wall));
                        visited[nex][ney][cu.wall] = true;
                    }
                } else if (arr[nex][ney] == 1) {
                    if (cu.wall == 0 && !visited[nex][ney][1]) {
                        queue.add(new Node(nex, ney, cu.count + 1, 1));
                        visited[nex][ney][1] = true;
                    }
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M][2];
        for (int i = 0; i<N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        bw.write(bfs(0, 0) + "");

        bw.flush();
        bw.close();
    }
}