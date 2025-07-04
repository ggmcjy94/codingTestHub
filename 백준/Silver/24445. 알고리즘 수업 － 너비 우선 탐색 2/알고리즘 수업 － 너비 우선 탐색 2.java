import java.io.*;
import java.util.*;

public class Main {
    static int N,M,V;
    static List<List<Integer>> arr;
    static boolean[] visited;
    static int[] order;
    static int cnt= 0;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        order = new int[N + 1];
        visited = new boolean[N+1];
        arr = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i <  M; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            arr.get(v).add(x);
            arr.get(x).add(v);
        }

        for (int i = 1; i <=N; i++) {
            arr.get(i).sort(Collections.reverseOrder());
        }

        bfs(V);

        for (int i = 1; i <= N; i++) {
            bw.write(order[i]+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int v) {
        // 1 2 4 
        // 2 1 3 4
        // 3 2 3
        // 4 1 2 3
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;
        order[v] = ++cnt;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            List<Integer> integers = arr.get(poll);
            for (Integer integer : integers) {
                if (!visited[integer]) {
                    visited[integer] = true;
                    order[integer] = ++cnt;
                    queue.offer(integer);
                }
            }
        }
    }
}