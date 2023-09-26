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
    static int N,M,K,r,g,b,res;
    static int max = Integer.MIN_VALUE;
    static int min_count = 0;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static void bfs(int k) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(k);
        visited[k]=true;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (Integer i : list.get(poll)) {
                if (!visited[i]){
                    queue.add(i);
                    visited[i]= true;
                    min_count++;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.get(e).add(s);
        }
        int[] result = new int[N+1];
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N+1];
            min_count = 0;
            bfs(i);
            result[i] = min_count;
            max = Math.max(max, min_count);
        }
        for (int i = 1; i<=N; i++) {
            if (result[i] == max) {
                bw.write(i +" ");
            }
        }
        bw.flush();
        bw.close();
    }
}