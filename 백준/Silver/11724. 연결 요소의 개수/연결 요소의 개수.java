
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static int[][] arr;
    static int n,m;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n+1][n+1];
        for (int i = 0; i<m; i++) {
            st = new StringTokenizer(br.readLine() , " ");
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            arr[v1][v2] = 1;
            arr[v2][v1] = 1;
        }
        visited = new boolean[n+1];
        cnt = 0;
        for (int i = 1; i<=n; i++) {
            if (!visited[i]) {
                bfs(i);
                cnt++;
            }
        }
        bw.write(cnt + "");
        bw.flush();
        bw.close();
    }
    private static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visited[x] = true;
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            for (int i =1; i <=n;i++){
                if (arr[temp][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
    private static void dfs(int i) {
        visited[i] = true;
        if (i == arr.length) return;
        for (int j = 1; j < arr.length; j++) {
            if (arr[i][j] == 1 && !visited[j]) {
                cnt++;
                dfs(j);
            }
        }
    }
}