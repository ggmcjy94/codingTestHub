import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br;
    static BufferedWriter bw;
    static int N,M;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {1, 0 , -1, 0};
    static int[] dy = {0, 1 , 0, -1};
    static int max,count = 0;
    
    static void bfs(int x , int y) {
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        visited[x][y] = true;
        count = 1;
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nox = poll[0];
            int noy = poll[1];
            for (int i = 0; i<4; i++) {
                int nex = nox + dx[i];
                int ney = noy + dy[i];
                if (nex < 0 || nex >= N || ney < 0 || ney>=M) continue;
                if (arr[nex][ney] == 1 && !visited[nex][ney]) {
                    queue.add(new int[]{nex, ney});
                    visited[nex][ney] = true;
                    count++;
                }
            }

        }
        max = Math.max(max,count);
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
//6 5
//0 0 0 0 0
//0 0 0 0 0
//0 0 0 0 0
//0 0 0 0 0
//0 0 0 0 0
//0 0 0 0 0
        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i< N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0 ; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int total = 0;
        for (int i = 0; i <N; i++) {
            for (int j =0; j<M; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    total++;
                    bfs(i, j);
                }
            }
        }
        bw.write(total+"\n");
        bw.write(max+"");
        bw.flush();
        bw.close();
    }
}
