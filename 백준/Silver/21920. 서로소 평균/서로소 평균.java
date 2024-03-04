import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int T,N,X,C,V,S,E,M,Q,K,R,min,max;
    static long ans;
    static int[][] dis;
    static char[][] map;
    static int[] arr,nums,operator,order,dist;
    static int[] selected,used;
    static int[] dp,A;
    static int dx[] = {0, -1, 0 ,1};
    static int dy[] = {1, 0, -1, 0};
    static ArrayList<Integer>[] graph;
    static boolean[][] visited,possible;
    static boolean[][][] visit;
    static StringBuilder sb = new StringBuilder();

    static boolean solve(long val) {
        for (long i = 2; i <= Math.sqrt(val); i++) {
            if (val % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static long gcd (long x, long y) {
        while (y != 0) {
            long temp = x % y;
            x = y;
            y = temp;
        }
        return x;
    }

    private static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[N+1];
        for (int i = 1; i<=N; i++) arr[i] = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(br.readLine());

        long sum = 0;
        int cnt = 0;

        for (int i = 1; i<=N; i++) {
            if (gcd(X, arr[i]) == 1) {
                sum += arr[i];
                cnt++;
            }
        }
        System.out.printf("%.6f", (double) sum /cnt);
        bw.flush();
        bw.close();
        br.close();
    }

}
