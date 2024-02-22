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
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        int[] x = new int[M+1];
        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=M; i++) x[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(x, 1, M+1);
        int L = 0, R=N, ans = N;
        while (L <= R) {
            int mid = (L + R) /2; //1
            int last = 0;
            for (int i = 1; i<= M; i++) {
                if (x[i]- last <= mid){
                    last = x[i] + mid;
                } else {
                    last = Integer.MIN_VALUE;
                    break;
                }
            }
            boolean check= last >= N;
            if (check) {
                ans = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        bw.write(ans+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
