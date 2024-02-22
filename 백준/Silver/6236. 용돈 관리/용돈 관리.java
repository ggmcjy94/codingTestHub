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
        int[] arr = new int[N+1];
        for (int i =1; i<= N; i++) arr[i] = Integer.parseInt(br.readLine());
        int L = arr[1], R = 1000000000, ans = 0;
        // 100 400 300 100 500 101 400
        //       1           2   3   4
        // sum 100 400 300 100 500 101 400
        // cnt 1 2 3 4 5 6 7
        for (int i = 1; i<= N; i++) L = Math.max(L , arr[i]);
        while (L <= R) {
            int mid = (L + R) / 2;
            int sum = 0;
            int cnt = 1;
            for (int i = 1; i<=N; i++) {
                if (sum+arr[i] > mid) {
                    cnt++;
                    sum = arr[i];
                } else {
                    sum += arr[i];
                }

            }
            boolean chk = cnt <= M;

            if (chk) {
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
