import java.io.*;
import java.util.*;

public class Main {
    static int N,M,cnt;
    static int[][] arr;
    static ArrayList<ArrayList<Integer>> arr2;
    static int[] result;
    static boolean[] visited;
    static boolean[][] visited2;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static BufferedWriter bw;
    static Queue<int[]> queue = new LinkedList<>();

    static void bfs() {
        while (!queue.isEmpty()) {
            int x = queue.peek()[0];
            int y = queue.peek()[1];
            queue.poll();
            for (int i = 0; i<4; i++) {
                int nx = x+dx[i];
                int ny = y+dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < M){
                    if(arr[nx][ny] == 0) {
                        arr[nx][ny] = arr[x][y]+1;
                        queue.add(new int[]{nx, ny});
                    }

                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        //6 4
        //0 0 0 0 0 0
        //0 0 0 0 0 0
        //0 0 0 0 0 0
        //0 0 0 0 0 1
        for (int i =0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
          }
        }
        bfs();
        for (int i = 0; i< N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                cnt = Math.max(cnt, arr[i][j]);
            }
        }
        bw.write(cnt-1+"");
        bw.flush();
        bw.close();
    }
}
