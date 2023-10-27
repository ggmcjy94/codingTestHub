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

    static int res = Integer.MIN_VALUE;


    //5 100 3
    //1 1 1 0 0
    //1 0 1 0 0
    //0 0 1 1 1
    //1 1 0 0 0
    //0 1 1 0 1
    private static int bfs(int y, int x, int[][] map, boolean[][]visited, int n, int k) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y,x});
        visited[y][x] = true;
        int cnt = 0;
        while(!q.isEmpty()){
            int[] now = q.poll();
            cnt++;
            for(int i = 0 ; i < 4 ; i++){
                int ny = now[0] + dx[i];
                int nx = now[1] + dy[i];
                if(ny >= 0 && ny < n && nx >= 0 && nx < n && !visited[ny][nx] && map[ny][nx] == 0){
                    visited[ny][nx] = true;
                    q.offer(new int[]{ny,nx});
                }
            }
        }
        int result = cnt / k;
        if(cnt % k != 0){
            result++;
        }
        return result;
    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = cal(arr,N,K);

        if(result > M || M == 0 || result == 0){
            System.out.println("IMPOSSIBLE");
        }else{
            System.out.println("POSSIBLE");
            System.out.println(M - result);
        }
        bw.flush();
        bw.close();
    }

    private static int cal(int[][] arr, int n, int k) {
        boolean[][] visited = new boolean[n][n];
        int cnt = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(!visited[i][j] && arr[i][j] == 0){
                    cnt += bfs(i,j,arr,visited,n,k);
                }
            }
        }
        return cnt;
    }
}
