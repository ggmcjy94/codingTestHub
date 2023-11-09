import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {

    static BufferedReader br;
    static BufferedWriter bw;
    static int T, N ,M,H,K, a,b,P;
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

    //5 1
    //3
    //1
    //5
    //3

    // 1 2 3 4 5         6

    //5 2
    //3
    //1
    //5
    //3

    // 1 2 3 4 5
    // 4

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(br.readLine());
        int res = 0;
        int s = 1, e = M; // 1
        for (int i = 0; i < T; i++) { // 1 5 3
            int apple = Integer.parseInt(br.readLine());
            if (s > apple){
                res += s - apple; // 6
                e -= s - apple; // -3
                s = apple; // 3
            } else if (e < apple) {
                res += apple - e; // 4
                s += apple - e; // 5
                e = apple; // 5
            }
        }

        bw.write(res + "");
        bw.flush();
        bw.close();
    }
}