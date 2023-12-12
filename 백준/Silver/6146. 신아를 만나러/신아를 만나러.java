import java.io.*;
import java.util.*;

public class Main {


    static int X,Y,N, res;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0, -1};



    private static void bfs() {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{500,500, 0});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nox = poll[0];
            int noy = poll[1];
            for (int i = 0; i < 4; i++) {
                int nex = nox + dx[i];
                int ney = noy + dy[i];
                if (Math.abs(nex) <= 1001 && Math.abs(ney) <= 1001 && !visited[nex][ney]) {
                    visited[nex][ney] =true;
                    if (nex == X && ney == Y) {
                        res = poll[2]+1;
                        return;
                    }
                    queue.add(new int[]{nex,ney , poll[2]+1});
                }
            }

        }

    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        X = Integer.parseInt(st.nextToken()) + 500;
        Y = Integer.parseInt(st.nextToken()) + 500;
        N = Integer.parseInt(st.nextToken());
        arr = new int[1001][1001];
        visited = new boolean[1001][1001];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) + 500;
            int y = Integer.parseInt(st.nextToken()) + 500;
            visited[x][y] = true;
        }
        bfs();
        bw.write(res+"");
        br.close();
        bw.flush();
        bw.close();

    }

}
