import java.io.*;
import java.util.*;

public class Main {
    static int T,N,X,C,V,S,E,M,Q,K,R,min,max;
    static int[][] dis, map, arr;
    static int dx[] = {0, -1, 0 ,1};
    static int dy[] = {1, 0, -1, 0};
    static boolean[][] visited,possible;
    static boolean[] visit;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[][] checked;
    static StringBuilder sb = new StringBuilder();
    static int cnt;

    static void bfs (int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        visit[i] = true;
        cnt = 0;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            cnt++;
            for (Integer a : graph.get(poll)) {
                if (visit[a]) continue;
                queue.add(a);
                visit[a] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visit = new boolean[N+1];
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(b).add(a);
        }
        X = Integer.parseInt(br.readLine());

        bfs(X);
        int res = cnt - 1;
        bw.write(res +"");
        bw.flush();
        bw.close();
        br.close();
    }

}
