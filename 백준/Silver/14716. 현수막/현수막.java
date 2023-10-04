import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br;
    static BufferedWriter bw;
    static int[][] arr;
    static char[][] str_arr;
    static boolean[][] visited;
    static int[][] result;
    static int[] dx = {1,0,-1,0, -1, 1,-1, 1};
    static int[] dy = {0,1,0,-1, -1, 1, 1,-1};
    static int N,M,K,X,r,g,b,res;
    static int max = Integer.MIN_VALUE;
    static int min_count = 0;
    static int w_cnt,b_cnt,w_res, b_res;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static List<Integer> arr2 = new ArrayList<>();
    static int maxHeight=0;
    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nox = poll[0];
            int noy = poll[1];
            for (int i = 0; i < 8; i++) {
                int nex = nox + dx[i];
                int ney = noy + dy[i];
                if (nex < 0 || nex >= N || ney <0 || ney >= M) continue;
                if (arr[nex][ney] == 1 && !visited[nex][ney]) {
                    queue.add(new int[]{nex, ney});
                    visited[nex][ney] = true;
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
            for (int j =0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 0;
        for (int i = 0; i<N; i++) {
            for (int j = 0; j<M; j++) {
                if (arr[i][j] ==1 && !visited[i][j]) {
                    bfs(i,j);
                    cnt++;
                }
            }
        }
        bw.write(cnt+"");
        bw.flush();
        bw.close();
    }
}
