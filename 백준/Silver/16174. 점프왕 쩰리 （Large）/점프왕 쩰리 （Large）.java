import java.io.*;
import java.util.*;

public class Main {

    static int N, C,K;
    static int ans;
    static int[][] map;
    static int[][] copyMap;
    static boolean[][] visited;
    static int[] dx = {0 , 1};
    static int[] dy = {1 , 0};


  //3
    //1 1 10
    //1 5 1
    //2 2 -1

    //3
    //2 2 1
    //2 2 2
    //1 2 -1
    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nox = poll[0];
            int noy = poll[1];
            if (map[nox][noy] == -1) break;
            for (int i = 0; i < 2; i++) {
                int nx = nox + (dx[i]*map[nox][noy]);
                int ny = noy + (dy[i]*map[nox][noy]);
                if (nx >= N || ny >= N) continue;
                if (visited[nx][ny]) continue;
                queue.add(new int[]{nx,ny});
                visited[nx][ny] = true;
            }
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(0, 0);

        if (visited[N-1][N-1]) {
            bw.write("HaruHaru");
        } else {
            bw.write("Hing");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}