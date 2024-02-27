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
    static boolean[][] visit;
    static int[] apart = new int[25*25];
    static int apartNum = 0;
    static StringBuilder sb = new StringBuilder();


    static void bfs(int x, int y ) {
        visit[x][y] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        apart[apartNum]++;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int now_x = poll[0];
            int now_y = poll[1];
            for (int i = 0 ; i < 4; i++) {
                int next_x = dx[i] + now_x;
                int next_y = dy[i] + now_y;
                if (next_x < 0 || next_x >= N || next_y < 0 || next_y >= N ) continue;
                if (dis[next_x][next_y] == 0 || visit[next_x][next_y]) continue;
                queue.add(new int[]{next_x, next_y});
                visit[next_x][next_y] = true;
                apart[apartNum]++;
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
        N = Integer.parseInt(br.readLine());
        dis = new int[N][N];
        visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j<N; j++) {
                dis[i][j] = s.charAt(j) - '0';
            }
        }
        int cnt=0;
        for (int i = 0; i<N; i++) {
            for (int j = 0; j < N; j++) {
                if (dis[i][j] == 1 && !visit[i][j]) {
                    apartNum++;
                    bfs(i, j);
                }
            }
        }
        Arrays.sort(apart);
        bw.write(apartNum+"\n");
        for (int i = 0; i<apart.length; i++) {
            if (apart[i] != 0) {
                bw.write(apart[i]+"\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
