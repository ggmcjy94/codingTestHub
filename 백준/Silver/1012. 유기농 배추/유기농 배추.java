import java.io.*;
import java.util.*;

public class Main {

    static int M,N,K,count;
    static int[][] arr;
    static boolean[][] visited;
    static int dx[] = { 1,0,-1,0 };
    static int dy[] = { 0,1,0,-1 };


    static void bfs(int i , int j) {
        Queue<int[]> qu = new LinkedList<>();
        qu.add(new int[]{i,j});

        while (!qu.isEmpty()){
            int x = qu.peek()[0];
            int y = qu.peek()[1];
            visited[x][y] = true;
            qu.poll();

            for (int c = 0; c < 4; c++) {
                int cx = x + dx[c];
                int cy = y + dy[c];

                if (cx >= 0 && cy >= 0 && cx <M && cy<N) {
                    if (!visited[cx][cy] && arr[cx][cy]==1){
                        qu.add(new int[]{cx, cy});
                        visited[cx][cy] = true;
                    }
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int p = 0; p<T; p++) {
            st = new StringTokenizer(br.readLine()," ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            arr = new int[M][N];
            visited= new boolean[M][N];
            count=0;
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[x][y] = 1;
            }

            for (int i = 0; i <M; i++){
                for (int j = 0; j< N; j++) {
                    if (arr[i][j] == 1 && !visited[i][j]) {
                        bfs(i,j);
                        count++;
                    }
                }
            }
            bw.write(count+"\n");
        }


        //2
        //10 8 17
        //0 0
        //1 0
        //1 1
        //4 2
        //4 3
        //4 5
        //2 4
        //3 4
        //7 4
        //8 4
        //9 4
        //7 5
        //8 5
        //9 5
        //7 6
        //8 6
        //9 6
        //10 10 1
        //5 5

        //5
        //1
        bw.flush();
        bw.close();
    }
}