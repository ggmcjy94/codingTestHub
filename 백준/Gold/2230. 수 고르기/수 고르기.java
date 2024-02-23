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
        M = Integer.parseInt(st.nextToken());
        int[] A = new int[N+1];
        for (int i =1; i<=N; i++) A[i] = Integer.parseInt(br.readLine());

        // 1 3 5
        Arrays.sort(A);
        int R = 1, ans = Integer.MAX_VALUE;
        for (int L = 1; L <= N; L++) {
            while (R + 1 <= N && A[R] - A[L] < M) {
                ++R;
            }

            if (A[R] - A[L] >= M) {
                ans = Math.min(ans , A[R]- A[L]);
            }
        }

        bw.write(ans +"");
        bw.flush();
        bw.close();
        br.close();
    }
}
