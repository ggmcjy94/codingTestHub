import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int T,N,C,S,E,M,Q,K,min,max;
    static long ans;
    static int[][] dis;
    static int[] arr,nums,operator,order;
    static int[] selected,used;
    static int[] dp,A;
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
        A = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i<= N; i++) A[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(A, 1 , N+1);
        // -99 -2 -1 4 98
        int L = 1, R= N, sum = Integer.MAX_VALUE, v1=0, v2=0;

        while (L < R) {
            if (sum > Math.abs(A[L] + A[R])) {
                sum = Math.abs(A[L] + A[R]);
                v1 = A[L];
                v2 = A[R];
            }

            if (A[L] + A[R] > 0) R--;
            else L++;
        }
        bw.write(v1 + " " + v2);
        bw.flush();
        bw.close();
        br.close();
    }

}
