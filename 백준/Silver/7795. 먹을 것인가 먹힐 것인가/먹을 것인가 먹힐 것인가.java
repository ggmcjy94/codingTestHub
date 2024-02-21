import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int T,N,S,E,M,R,Q,K,min,max;
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
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int[] arr1 = new int[A+1];
            int[] arr2 = new int[B+1];
            st = new StringTokenizer(br.readLine());
            for (int a = 1; a <= A; a++) arr1[a] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int b = 1; b <= B; b++) arr2[b] = Integer.parseInt(st.nextToken());
            Arrays.sort(arr2, 1, B+1);
            int ans = 0;
            for (int j = 1 ; j <= A; j++) ans += bs(arr2,1, B,arr1[j]);
            bw.write(ans+" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    static int bs (int[] A, int L, int R, int X) {
        // 1 1 3 7 8
        // 3 6 1
        int result = L - 1;
        while (L <= R) {
            int m = (L+R) / 2;
            if (A[m] < X) {
                result = m;
                L = m + 1;
            } else if (A[m] >= X) {
                R = m - 1;
            }
        }
        return result;
    }
}
