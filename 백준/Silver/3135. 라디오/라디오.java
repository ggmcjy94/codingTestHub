import java.io.*;
import java.util.*;


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

    //라디오
    //88 17
    //3
    //18
    //1
    //42

    // 1 3 17 18 42

    // 18 1 2
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(br.readLine());
        int[] arr = new int[T+1];
        for (int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        arr[T] = M;
        Arrays.sort(arr);
        res = 0;
        for (int i = 0; i < T+1; i++) {
            if (arr[i] == M) {
                if (i == T) {
                    res = arr[i] - arr[i-1] +1;
                } else if (i == 0) {
                    res = arr[i+1] - arr[i] + 1;
                } else {
                    res = Math.min(arr[i] - arr[i-1], arr[i+1] - arr[i])+1;
                }
            }
        }
        if (M >= N) res = Math.min(M-N,res);
        if (N >= M) res = Math.min(N-M,res);
        bw.write(res+"");
        bw.flush();
        bw.close();
    }
}