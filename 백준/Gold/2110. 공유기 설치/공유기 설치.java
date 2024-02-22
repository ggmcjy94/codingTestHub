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
        C = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        for (int i = 1 ; i<=N; i++) arr[i] = Integer.parseInt(br.readLine());
        // 1 2 4 8 9
        Arrays.sort(arr, 1, N+1);
        int L = 1, R = 1000000000, ans = 0;

        while (L <= R) {
            int mid = (L+R) / 2;
            int cnt = 1, last = arr[1];
            for (int i = 2; i <= N; i++){
                if (arr[i] - last < mid) continue;
                last = arr[i];
                cnt++;
            }
            boolean check = cnt >= C;

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
