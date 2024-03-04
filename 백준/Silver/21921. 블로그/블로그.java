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
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (i <= X) sum += arr[i];
        }

        int max_sum = sum;
        int cnt = 1;

        int left = 1;
        int right = X;

        while (true) {
            left++;
            right++;
            if (right > N) break;

            sum = sum + arr[right] - arr[left - 1];
            if (max_sum == sum) {
                cnt++;
            }
            else if (max_sum < sum) {
                max_sum = sum;
                cnt = 1;
            }
        }
        if (max_sum == 0) bw.write("SAD");
        else {
            bw.write(max_sum + "\n");
            bw.write(cnt+"");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
