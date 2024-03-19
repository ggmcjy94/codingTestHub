import java.io.*;
import java.util.*;

public class Main {

    static int N,M,C,R,T,A,B;
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
    static int[] dist;
    static StringBuilder sb = new StringBuilder();

    static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        int cnt = 1;
        dist[x] = cnt++;
        visit[x] = true;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (Integer integer : graph[poll]) {
                if (visit[integer]) continue;
                queue.add(integer);
                visit[integer] = true;
                dist[integer] = cnt++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        visit = new boolean[N+1];
        dist = new int[N+1];
        for (int i = 0; i <= N; i++) graph[i] = new ArrayList<>();
        for (int i = 0 ; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        for (int i = 0; i <= N; i++) {
            Collections.sort(graph[i]);
        }
        bfs(R);
        for (int i = 1; i <= N; i++) {
            bw.write(dist[i] +"\n");
        }
//        bw.write(ans+"\n");
//        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}

