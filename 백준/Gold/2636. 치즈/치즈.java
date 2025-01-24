import java.io.*;
import java.util.*;

public class Main {

    static int N ,M ,min,cheezeCnt ;
    static int res = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[][] holeVisited;
    static boolean[][] cheezeVisited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0 ,-1,1};
    static Queue<int[]> queue = new LinkedList<>();
    //13 12
    //0 0 0 0 0 0 0 0 0 0 0 0
    //0 0 0 0 0 0 0 0 0 0 0 0
    //0 0 0 0 0 0 0 1 1 0 0 0
    //0 1 1 1 0 0 0 1 1 0 0 0
    //0 1 1 1 1 1 1 0 0 0 0 0
    //0 1 1 1 1 1 0 1 1 0 0 0
    //0 1 1 1 1 0 0 1 1 0 0 0
    //0 0 1 1 0 0 0 1 1 0 0 0
    //0 0 1 1 1 1 1 1 1 0 0 0
    //0 0 1 1 1 1 1 1 1 0 0 0
    //0 0 1 1 1 1 1 1 1 0 0 0
    //0 0 1 1 1 1 1 1 1 0 0 0
    //0 0 0 0 0 0 0 0 0 0 0 0

    //3 모두 녹아서 없어지는 시간
    //5 녹기 한시간존 칸

    private static void holeCheckDfs(int r, int c) {

        for (int i = 0; i < 4; i++) {
            int nx =  r + dx[i];
            int ny = c + dy[i];
            if (nx < 0|| ny < 0 || nx >=N || ny >= M || holeVisited[nx][ny] || map[nx][ny] == 1) continue;
            holeVisited[nx][ny] = true;
            holeCheckDfs(nx,ny);
        }
    }
    private static void cheezeBfs(int r, int c) {
        queue.add(new int[]{r,c});
        cheezeVisited[r][c] = true;
        int cnt = 1;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0] , y = poll[1];
            for (int i = 0; i <4 ; i++ ) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0|| ny < 0 || nx >=N || ny >= M || cheezeVisited[nx][ny]) continue;
                if (map[nx][ny] == 1) {
                    queue.offer(new int[]{nx,ny});
                    cheezeVisited[nx][ny] = true;
                    cnt++;
                }
                if (map[x][y] == 1) {
                    if (map[nx][ny] == 0 && holeVisited[nx][ny]) {
                        map[x][y] = 0;
                    }
                }
            }
        }
        min += cnt;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        holeVisited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            min = 0;
//            for (int[] ints : map) {
//                System.out.println();
//                for (int anInt : ints) {
//                    System.out.print(anInt +" ");
//                }
//            }
            holeVisited= new boolean[N][M];
            cheezeVisited = new boolean[N][M];
            holeCheckDfs(0, 0);
            queue = new LinkedList<>();

            boolean flag = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1 && !cheezeVisited[i][j]) {
                        flag = true;
                        cheezeBfs(i, j);
                    }
                }
            }
//            System.out.println(min);
            if (min > 0) {
                res = Math.min(min, res);
            }

            if (!flag)  {
                bw.write(cheezeCnt+"\n");
                break;
            } else {
                cheezeCnt++;
            }

        }

        bw.write(res+"");
        bw.flush();
        bw.close();
        br.close();
    }



}