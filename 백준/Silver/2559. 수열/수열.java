import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int T,N,C,S,E,M,Q,K,min,max;
    static long ans;
    static int[][] dis;
    static int[] arr,nums,operator,order;
    static int[] selected,used;
    static int[] dp;
    static int dx[] = {0, -1, 0 ,1};
    static int dy[] = {1, 0, -1, 0};
    static Queue<int[]> queue = new LinkedList<>();
    static ArrayList<Integer>[] con;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i<= N; i++) arr[i] = Integer.parseInt(st.nextToken());
        int R = 0,sum = 0, ans = -100 * N;
        //3 -2 -4 -9 0 3 7 13 8 -3

        for (int L = 1; L + S - 1<= N; L++) {
            sum -= arr[L - 1];
            while (R+1 <= L + S - 1) {
                sum += arr[++R];
            }
            ans = Math.max(sum, ans);
        }

        bw.write(ans +"");
        bw.flush();
        bw.close();
        br.close();
    }
}
