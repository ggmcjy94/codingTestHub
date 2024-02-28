import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int T,N,C,V,S,E,M,Q,K,R,min,max;
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

    static void dfs(int x, int par) {
        for (Integer y : graph[x]) {
            if (y == par) continue;
            used[y] = x;
            dfs(y, x);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        used = new int[N+1];
        for (int i = 1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        dfs(1, -1);
        for (int i = 2; i <= N; i++) {
            sb.append(used[i]).append('\n');
        }
        System.out.println(sb);
        bw.flush();
        bw.close();
        br.close();
    }

}
