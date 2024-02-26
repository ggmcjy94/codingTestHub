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
        st = new StringTokenizer(br.readLine());
        int[] A = new int[N+1];
        for (int i = 1; i<=N; i++) A[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(A, 1 , N+1);

        int L = 1, R = N,val1=0, val2=0, sum = Integer.MAX_VALUE;
        while (L < R) {
            int abs = Math.abs(A[L] + A[R]);
            if (sum > abs) {
                sum = abs;
                val1 = A[L];
                val2 = A[R];
            }


            if (A[L] + A[R] > 0) R--;
            else L++;
        }

        bw.write(val1 +" " + val2);
        bw.flush();
        bw.close();
        br.close();
    }

}
