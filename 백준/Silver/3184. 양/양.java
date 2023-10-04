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
    static int v_cnt,o_cnt,v_res, o_res;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static List<Integer> arr2 = new ArrayList<>();
    static int maxHeight=0;
    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y] = true;
        v_cnt = 0;
        o_cnt = 0;
        if (str_arr[x][y] == 'v') v_cnt++;
        if (str_arr[x][y] == 'o') o_cnt++;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nox = poll[0];
            int noy = poll[1];
            for (int i = 0; i < 4; i++) {
                int nex = nox + dx[i];
                int ney = noy + dy[i];
                if (nex < 0 || nex >= N || ney < 0 || ney >= M) continue;
                if (str_arr[nex][ney] != '#' && !visited[nex][ney]) {
                    queue.add(new int[]{nex, ney});
                    visited[nex][ney] = true;
                    if (str_arr[nex][ney] == 'v') v_cnt++;
                    if (str_arr[nex][ney] == 'o') o_cnt++;
                }
            }
        }
        if (v_cnt >= o_cnt) v_res += v_cnt;
        if (o_cnt > v_cnt) o_res += o_cnt;
    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        str_arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                str_arr[i][j] = s.charAt(j);
            }
        }

        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (str_arr[i][j] != '#'&& !visited[i][j]) {
                    bfs(i,j);
                }
            }
        }
        bw.write(o_res + " ");
        bw.write(v_res+"");
        bw.flush();
        bw.close();
    }
}
