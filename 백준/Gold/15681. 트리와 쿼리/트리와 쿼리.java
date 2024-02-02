import java.io.*;
import java.util.*;

public class Main {
    static int T,N,S,E,M,R,Q,K,min,max;
    static long ans;
    static int[][] arr;
    static int[] dp;
    static int dx[] = {0, -1, 0 ,1};
    static int dy[] = {1, 0, -1, 0};
    static Queue<int[]> queue = new LinkedList<>();
    static ArrayList<Integer>[] con;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int x, int prev) {
        dp[x] = 1;
        for (Integer y : con[x]) {
            if (y == prev)  continue;
            dfs(y, x);
            dp[x] += dp[y];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        con = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            con[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N-1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            con[a].add(b);
            con[b].add(a);
        }


        dp = new int[N+1];
        dfs(R, -1);

        sb = new StringBuilder();
        for (int i = 1; i <= Q; i++) {
            int q = Integer.parseInt(br.readLine());
            sb.append(dp[q]).append('\n');
        }
        // 1
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
