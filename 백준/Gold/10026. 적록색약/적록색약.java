import java.io.*;
import java.util.*;

public class Main {


    static int N;
    static char[][] map, gMap;
    static boolean[][] visited;
    static int[] dx = {0 ,0 ,-1,1};
    static int[] dy = {1, -1, 0, 0};

    static void dfs(int x, int y) {
        char a = map[x][y];
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx <0 || ny < 0 || nx>=N || ny >= N || visited[nx][ny]) continue;
            if (a == map[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny);
            }
        }

    }
    static void gdfs(int x, int y) {
        char a = gMap[x][y];
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx <0 || ny < 0 || nx>=N || ny >= N || visited[nx][ny]) continue;
            if (a == gMap[nx][ny]) {
                visited[nx][ny] = true;
                gdfs(nx, ny);
            }

        }

    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        gMap = new char[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] =='G') {
                    gMap[i][j] = 'R';
                } else {
                    gMap[i][j] = map[i][j];
                }


            }
        }
        visited = new boolean[N][N];
        int res = 0;
        int gRes = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    res++;
                    dfs(i, j);
                }
            }
        }



        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    gRes++;
                    gdfs(i, j);
                }
            }
        }
        bw.write(res+" " + gRes);
        bw.flush();
        bw.close();
        br.close();


    }




}