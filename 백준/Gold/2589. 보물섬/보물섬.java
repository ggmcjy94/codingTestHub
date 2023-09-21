import java.io.*;
import java.util.*;
public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static char[][] map;
    static int[][] visit;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int N,M,res;
    static Queue<int[]> queue = new LinkedList<>();
    //5 7
    //W L L W W W L
    //L L L W L L L
    //L W L W L W W
    //L W L W L L L
    //W L L W L W W
    static void bfs(int x , int y) {
        for(int i = 0 ; i< N ; i++) {
            for(int j=0 ; j < M ; j++) {
                visit[i][j] = -1;
            }
        }
        visit[x][y] = 0;
        queue.add(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int now_x = poll[0];
            int now_y = poll[1];
            for (int i = 0; i < 4; i++) {
                int next_x = now_x + dx[i];
                int next_y = now_y + dy[i];

                if(next_x < 0 || next_x >= N || next_y < 0 || next_y >= M) continue;

                if(map[next_x][next_y] == 'L' && visit[next_x][next_y] == -1) {
                    visit[next_x][next_y] = visit[now_x][now_y] +1;
                    queue.add(new int[] {next_x, next_y});
                    res = Math.max(res, visit[next_x][next_y]);
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
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j<M; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        for (int i = 0; i<N; i++) {
            for (int j =0; j<M; j++) {
                if (map[i][j] =='L') {
                    visit = new int[N][M];
                    bfs(i , j);
                }
            }
        }
        bw.write(res+"");
        bw.flush();
        bw.close();
    }
}