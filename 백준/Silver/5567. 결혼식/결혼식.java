import java.io.*;
import java.util.*;

public class Main {

    static int N,M,C,T,A,B;
    static int ans;
    static StringTokenizer st;
    static int[] dx = {1,0,-1,0,1,-1,-1,1};
    static int[] dy = {0,1,0,-1,1,1,-1,-1};
    static int[][] arr, brr;
    static ArrayList<Integer>[] graph;
    static char[][] map;
    static Queue<int[]> iceQueue;
    static boolean[][] visited;
    static boolean[] visit;


    static void dfs (int p , int c) {
        if (c == 2) return;

        for (int i : graph[p]) {
            visit[i] = true;
            dfs(i, c+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        visit = new boolean[N+1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        ans = 0;
        dfs(1, 0);
        for (int i = 2; i <= N; i++) {
            if (visit[i]) ans++;
        }
        bw.write(ans+"");
        bw.flush();
        bw.close();
        br.close();
    }

}

