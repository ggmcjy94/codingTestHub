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

    // 255 255 255
    // 0   255 0
    // 255 255 0

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int nox = p[0];
            int noy = p[1];
            for (int i = 0; i<4 ;i++) {
                int nex = nox + dx[i];
                int ney = noy + dy[i];
                if (nex < 0 || ney < 0 || nex >= N || ney >= M) continue;
                if (visited[nex][ney]) continue;
                if (arr[nex][ney] != 255) continue;
                queue.add(new int[]{nex, ney});
                visited[nex][ney] = true;
                cnt++;
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
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int sum = 0;
                for (int k = 0; k < 3; k++) {
                    sum += Integer.parseInt(st.nextToken());
                }
                arr[i][j] = sum;
            }
        }
        X = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] / 3 >= X) arr[i][j] = 255;
                else arr[i][j] = 0;
            }
        }
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <M; j++) {
                if (arr[i][j] == 255 && !visited[i][j]) {
                    cnt++;
                    bfs(i, j);
                }
            }
        }

        bw.write(cnt+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
