import java.io.*;
import java.util.*;

public class Main {
    static int N,M,R,K,min,max;
    static long ans;
    static long[] A, Dy;
    static ArrayList<Interval>[] intervals;
    static int[][] arr;
    static int[][] backUp;
    static String[] board;
    static Map<String, Integer> map = new HashMap<>();
    static int[] nums , operator, order, col;
    static int dx[] = {0, 0, -1, -1, -1, 1, 1, 1};
    static int dy[] = {1, -1, -1, 0, 1, -1, 0, 1};
    static Queue<int[]> queue = new LinkedList<>();
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();

    static class Interval{
        int left;
        long satisfy;
    }
    static void  pro () {
        long sum = 0;
        for (int L = 1, R = 0; L <= N; L++) {
            while (sum <  K && R + 1 <= N) sum += A[++R];
            if (sum >= K) {
                Interval i = new Interval();
                i.left = L;
                i.satisfy = sum - K;
                intervals[R].add(i);
            }
            sum -= A[L];
        }

        for (int R = 1; R <= N; R++) {
            Dy[R] = Dy[R-1];
            for (Interval i : intervals[R]) {
                Dy[R] = Math.max(Dy[R], Dy[i.left - 1] + i.satisfy);
            }
        }
        ans = Dy[N];
    }
    static void dfs(int i , int j, String path,int len){
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        A = new long[N+1];
        Dy = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }
        intervals = new ArrayList[N+1];
        for (int i = 1; i <= N; i++){
            intervals[i] = new ArrayList<>();
        }
        pro();
        bw.write(ans+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
