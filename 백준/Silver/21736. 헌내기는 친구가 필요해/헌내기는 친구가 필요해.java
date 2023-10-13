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
        visited[x][y] = true;
        for (int i = 0; i<4; i++) {
            int nex = x + dx[i];
            int ney = y + dy[i];
            if (nex < 0 ||nex >= N || ney <0 || ney >= M) continue;
            if (strArr[nex][ney] != 'X' && !visited[nex][ney]) {
                if (strArr[nex][ney] == 'P') {
                    cnt++;
                }
                visited[nex][ney] = true;
                dfs(nex, ney);
            }
        }

    }
    //3 5
    //OOOPO
    //OIOOX
    //OOOXP

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        strArr = new char[N][M];
        cnt  = 0;
        for (int i = 0; i<N; i++) {
            String reads = br.readLine();
            for (int j =0; j<M; j++) {
                strArr[i][j] = reads.charAt(j);
            }
        }
        visited = new boolean[N][M];

        for (int i = 0; i<N; i++) {
            for (int j =0; j <M; j++) {
                if (strArr[i][j] == 'I') {
                    dfs(i, j);
                }
            }
        }
        if (cnt > 0) {
            bw.write(cnt+"");
        } else {
            bw.write("TT");

        }

        bw.flush();
        bw.close();
    }
}
