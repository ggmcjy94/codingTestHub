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
        N = Integer.parseInt(br.readLine());
        int[] A = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i<=N; i++) A[i] = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());

        int[] B = new int[M+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i<=M; i++) B[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(A , 1, N+1);
        for (int i = 1; i<= M; i++) {
            int res = 0, L = 1, R = A.length-1;
            // 1 2 3 4 5
            // 1 3 7 9 5
            while (L <= R) {
                int mid = (L+R) / 2;
                if (A[mid] == B[i]) {
                    res = 1;
                    break;
                }
                if (A[mid] < B[i]) {
                    L = mid + 1;
                } else if (A[mid] >= B[i]) {
                    R  = mid - 1;
                }
            }
            bw.write(res+"\n");
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
