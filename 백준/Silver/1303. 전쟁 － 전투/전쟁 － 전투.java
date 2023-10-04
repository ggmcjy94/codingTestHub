import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br;
    static BufferedWriter bw;
    static int[][] arr;
    static char[][] str_arr;
    static boolean[][] visited;
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
    static void bfs(int x, int y, char target) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y] = true;
        w_cnt  = 1;
        b_cnt = 1;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nox = poll[0];
            int noy = poll[1];
            for (int i = 0; i<4; i++) {
                int nex = nox + dx[i];
                int ney = noy + dy[i];
                if (nex < 0 || nex >= N || ney < 0 || ney >= M) continue;
                if (str_arr[nex][ney] == target && !visited[nex][ney]) {
                    queue.add(new int[]{nex, ney});
                    visited[nex][ney] = true;
                    if (str_arr[nex][ney] == 'W') w_cnt++;
                    else if (str_arr[nex][ney] == 'B') b_cnt++;
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        str_arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                str_arr[i][j] = s.charAt(j);
            }
        }
        visited = new boolean[N][M];
        for (int i = 0; i< N; i++) {
            for (int j = 0; j < M; j++) {
                if (str_arr[i][j] == 'W' && !visited[i][j]){
                    bfs(i, j,'W');
                    w_res += Math.pow(w_cnt, 2);
                }
                if (str_arr[i][j] == 'B' && !visited[i][j]) {
                    bfs(i, j,'B');
                    b_res += Math.pow(b_cnt, 2);
                }
            }
        }
        bw.write(w_res+" " + b_res);
        bw.flush();
        bw.close();
    }
}