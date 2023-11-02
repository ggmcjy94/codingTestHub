import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br;
    static BufferedWriter bw;
    static int T, N ,M,H,K, a,b;
    static int R ,C;
    static List<ArrayList<Integer>> graph = new ArrayList<>();
    static int[][] arr;
    static char[][] s_arr;
    static int[][][] t_arr;
    static boolean[] visit;
    static boolean[][] visited;
    static boolean[][][] t_visited;
    static int cnt1, cnt2;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    static int[] dx2 = {1,0,-1,0,0,0};
    static int[] dy2 = {0,1,0,-1,0,0};
    static int[] dh2 = {0,0,0,0,1,-1};

    static int res = 0;


    //5 6
    //.#....
    //..#...
    //..#..#
    //...##.
    //.#....

    private static void bfs(int x , int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nox = poll[0];
            int noy = poll[1];
            for (int i = 0; i < 4; i++) {
                int nex = nox + dx[i];
                int ney = noy + dy[i];
                if (nex < 0 || nex >= N || ney < 0 || ney >= M) continue;

                if (s_arr[nex][ney] == '#' && !visited[nex][ney]) {
                    queue.add(new int[]{nex,ney});
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
        s_arr = new char[N][M];
        for (int i = 0; i < N; i++) {
            String reads = br.readLine();
            for (int j = 0; j < M; j++) {
                s_arr[i][j] = reads.charAt(j);
            }
        }
        visited = new boolean[N][M];
        cnt1 = 0;
        for (int i =0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (s_arr[i][j] == '#' && !visited[i][j]) {
                    cnt1++;
                    bfs(i,j);
                }
            }
        }

        bw.write(cnt1+"");
        bw.flush();
        bw.close();
    }
}