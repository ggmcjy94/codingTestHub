import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br;
    static BufferedWriter bw;

    static List<List<Integer>> graph = new ArrayList<>();
    static int[][] arr;
    static char[][] strArr;
    static boolean[] visit;
    static boolean[][] visited;
    static int[] checked;
    static int N , M,R, s,x,y;
    static int cnt = 0;
    static boolean chek;
    static int [][] d = {{0,1}, {1,0}, {1,1}, {-1,1}};
    static int[] dx = {1, 0, -1, 0};
    static int[] dy ={0, -1, 0 , 1};
    static int[] number;
    static int[] operator = new int[4];
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;

    private static void dfs(int x, int y) {
        //5 6
        //010101
        //010000
        //011101
        //100011
        //001011
        visited[x][y] = true;
        for (int i = 0; i<4; i++) {
            int nex = x + dx[i];
            int ney = y + dy[i];
            if (nex < 0 ||nex >= N || ney <0 || ney >= M) continue;
            if (arr[nex][ney] == 0 && !visited[nex][ney]) {
                if (nex == N-1) {
                    chek = true;
                    return;
                }
                visited[nex][ney]= true;
                dfs(nex, ney);
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

        for (int i = 0; i<N; i++) {
            String reads = br.readLine();
            for (int j = 0; j < M;j++) {
                arr[i][j] = reads.charAt(j) - '0';
            }
        }
        for (int j = 0; j<M; j++) {
            if(chek)break;
            if (arr[0][j] == 0) {
                visited = new boolean[N][M];
                dfs(0, j);
            }
        }

        if (chek) {
            bw.write("YES");
        } else {
            bw.write("NO");
        }


        bw.flush();
        bw.close();
    }
}
