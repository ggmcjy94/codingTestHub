import java.io.*;
import java.util.*;

public class Main {

    static int N,M, cnt;
    static int[][] arr;
    static boolean[] visited;
    static BufferedWriter bw;
    //7
    //6
    //1 2
    //2 3
    //1 5
    //5 2
    //5 6
    //4 7
    static void bfs(int k) {
        Queue<Integer> queue = new LinkedList<>();
        visited[k] = true;
        queue.add(k);
        cnt++;
        while (!queue.isEmpty()) {
            Integer temp = queue.poll();
            for (int i = 1; i <= N; i++) {
                if (arr[temp][i] == 1 && !visited[i]) {
                    visited[i]= true;
                    queue.add(i);
                }
            }
        }
    }

    static void dfs(int k) {
        visited[k] = true;
  //      if (k == N) return;
        for (int i = 1; i<=N; i++) {
            if (arr[k][i] == 1 && !visited[i]){
                cnt++;
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new int[N+1][N +1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s][e] = 1;
            arr[e][s] = 1;
        }
//        visited = new boolean[N+1];
//        bfs(1);
//        cnt = 0;
        visited = new boolean[N+1];
        dfs(1);
        bw.write(cnt+"");
        bw.flush();
        bw.close();
    }
}
