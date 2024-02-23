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

        int R = 0,sum=0, ans = -1;
        for (int L = 1; L <= N; L++) {
            while (R < N && sum < S){
                R++;
                if (arr[R] == 1) sum++;
            }

            if (sum == S) {
                if (ans == -1) ans = R - L + 1;
                ans = Math.min(ans, R - L + 1);
            }

            if (arr[L] == 1) sum--;
        }
        bw.write(ans +"");
        bw.flush();
        bw.close();
        br.close();
    }
}
