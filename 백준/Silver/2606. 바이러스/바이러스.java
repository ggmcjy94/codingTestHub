import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static int[][] arr;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        arr = new int[n+1][n+1];
        for (int i =1; i <= m; i++) {
            st = new StringTokenizer(br.readLine() , " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s][e] = 1;
            arr[e][s] = 1;
        }

        //7
        //6
        //1 2
        //2 3
        //1 5
        //5 2
        //5 6
        //4 7
        visited = new boolean[n+1];
        dfs(1);
        System.out.println(cnt);
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