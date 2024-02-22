import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int T,N,S,E,M,Q,K,min,max;
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
        M = Integer.parseInt(st.nextToken());
        int[] A = new int[N+1];
        for (int i = 1; i<= N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        long L = 0, R = Integer.MAX_VALUE, ans = 0;
        // 200
        while (L <= R) {
            long mid = (L+R) / 2;
            long sum = 0;
            for (int i = 1; i <= N; i++) {
                sum += A[i]/mid;
            }
            boolean check = sum>= M;
            if (check) {
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        bw.write(ans+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
