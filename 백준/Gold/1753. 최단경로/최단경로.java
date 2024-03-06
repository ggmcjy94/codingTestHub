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
    static int[] dist;
    static ArrayList<Edge>[] edges;

    static class Edge {
        int to , weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }


    static class Info {
        int idx, dist;

        public Info(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        dist = new int[N+1];
        edges = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) edges[i] = new ArrayList<>();


        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            edges[A].add(new Edge(B ,V));
        }

        for (int i = 1; i <= N; i++) dist[i] = Integer.MAX_VALUE;

        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(info -> info.dist));

        pq.add(new Info(K, 0));
        dist[K] = 0;

        while (!pq.isEmpty()) {
            Info info = pq.poll();

            if (dist[info.idx] != info.dist) continue;

            for (Edge e : edges[info.idx]) { // 22 33
                if (dist[info.idx] + e.weight >= dist[e.to]) continue; // 0 + 1  >= max

                dist[e.to] = dist[info.idx] + e.weight; // 22 33 41 510
                pq.add(new Info(e.to, dist[e.to]));
            }
        }

        for (int i = 1; i<=N; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                bw.write("INF\n");
            } else {
                bw.write(dist[i]+"\n");
            }


        }

        bw.flush();
        bw.close();
        br.close();
    }

}
