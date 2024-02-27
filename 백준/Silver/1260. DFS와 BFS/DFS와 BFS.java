import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int T,N,C,V,S,E,M,Q,K,min,max;
    static long ans;
    static int[][] dis;
    static int[] arr,nums,operator,order;
    static int[] selected,used;
    static int[] dp,A;
    static int dx[] = {0, -1, 0 ,1};
    static int dy[] = {1, 0, -1, 0};

    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();


    static void bfs(int k) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(k);
        visited[k] = true;

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            sb.append(poll).append(" ");
            for (Integer i : graph.get(poll)) {
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    static void dfs (int k) {
        visited[k] = true;
        sb.append(k).append(" ");
        for (Integer i : graph.get(k)) {
            if (!visited[i]) {
                dfs(i);
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
        V = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        for (int i = 1; i <=N; i++) {
            Collections.sort(graph.get(i));
        }

        visited = new boolean[N+1];
        dfs(V);
        sb.append('\n');
        visited = new boolean[N+1];
        bfs(V);


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}
