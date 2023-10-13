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
    }
    //7 8
    //--------
    //|------|
    //||----||
    //|||--|||
    //||----||
    //|------|
    //--------

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        strArr = new char[N][M];
        for (int i = 0; i < N; i++) {
            String reads = br.readLine();
            for (int j = 0; j < M; j++) {
                strArr[i][j] = reads.charAt(j);
            }
        }

        for (int i = 0; i<N; i++) {
            for (int j = 0; j < M; j++) {
                if (strArr[i][j] == '-') {
                    if (j == M-1 || strArr[i][j+1]  =='|'){
                        cnt++;
                    }
                }
                if (strArr[i][j] == '|') {
                    if (i == N-1 || strArr[i+1][j] == '-') {
                        cnt++;
                    }
                }
            }
        }
        bw.write(cnt+"");
        bw.flush();
        bw.close();
    }
}