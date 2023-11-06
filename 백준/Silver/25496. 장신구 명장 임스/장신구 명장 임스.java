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

    //195 4
    //20 1 8 1
    //두 번째 장신구와 네 번째 장신구를 만들고 나면 피로도는 197이 된다.
    //피로도가 200 미만이므로 첫 번째 장신구나 세 번째 장신구 중 하나를 더 제작할 수 있고, 따라서 만들 수 있는 최대 장신구의 개수는 세 개가 된다.
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        P = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int [] arr =new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //190 5
        //20 1 8 1 10
        Arrays.sort(arr);
        //1 1 8 20
        res = 0;
        for (int i : arr) {
            if (P >= 200) break;
            P += i;
            res++;
        }
        System.out.println(res);
        bw.flush();
        bw.close();
    }
}