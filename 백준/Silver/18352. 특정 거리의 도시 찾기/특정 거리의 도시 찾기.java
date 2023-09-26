import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br;
    static BufferedWriter bw;
    static int[][] arr;
    static boolean[] visited;
    static int[] result;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int N,M,K,X,r,g,b,res;
    static int max = Integer.MIN_VALUE;
    static int min_count = 0;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static List<Integer> arr2 = new ArrayList<>();
    static void bfs(int k) throws IOException {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(k, 0));
        visited[k] = true;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (poll.y == K) {
                arr2.add(poll.x);
            }
            for (int i : list.get(poll.x)) {
                if (!visited[i]) {
                    queue.add(new Node(i, poll.y+1));
                    visited[i] = true;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        // N, 도로의 개수 M, 거리 정보 K, 출발 도시의 번호 X
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.get(s).add(e);
        }
        //4 4 2 1
        //1 2
        //1 3
        //2 3
        //2 4
        visited = new boolean[N+1];
        bfs(X);
        if (arr2.size() == 0) bw.write("-1");
        Collections.sort(arr2);
        for (Integer integer : arr2) {
            bw.write(integer + "\n");
        }
        //4
        bw.flush();
        bw.close();
    }
    static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}