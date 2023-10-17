import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br;
    static BufferedWriter bw;
    static int N = 5;
    static int R ,C;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int res = -1;
    private static void bfs(int x, int y) {
        //빠른 숫자 탐색
//0 0 0 0 0
//0 0 -1 0 0
//0 0 0 0 0
//0 0 -1 0 0
//0 0 0 -1 1
//1 1


        //0 0 -1 0 0
        //0 0 -1 0 0
        //0 0 -1 0 0
        //0 0 -1 0 0
        //0 0 -1 0 1
        //1 1

        //-1
        visited[x][y] = true;
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[] {x, y, 0});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nox = poll[0];
            int noy = poll[1];
            for (int i = 0; i <4; i++) {
                int nex = nox + dx[i];
                int ney = noy + dy[i];
                if (nex < 0 || nex >= N ||ney < 0 || ney >= N) continue;
                if (arr[nex][ney] != -1 & !visited[nex][ney]) {
                    if (arr[nex][ney] == 1) {
                        res = poll[2] + 1;
                        break;
                    }
                    visited[nex][ney] = true;
                    queue.add(new int[]{nex,ney, poll[2] + 1});
                }

            }
            if (res != -1)
                break;
        }

    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        arr = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        bfs(R,C);
        bw.write(res + "");
        bw.flush();
        bw.close();
    }


}