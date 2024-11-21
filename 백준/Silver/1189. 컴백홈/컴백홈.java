import java.io.*;
import java.util.*;

public class Main {

    static int R, C,K;
    static int ans;
    static char[][] map;
    static int[][] copyMap;
    static boolean[][] visited;
    static int[] dx = {0 , 1 , 0 , -1};
    static int[] dy = {1 , 0 , -1, 0};

    static void dfs(int r, int c , int m) {

        if (r == 0 &&  c== C-1) {
            if (m == K) ans++;
            return;
        }


        for (int i = 0; i < 4; i++) {
            int nex = r + dx[i];
            int ney = c + dy[i];
            if (nex < 0 || nex >= R || ney <0 || ney>=C) continue;
            if (visited[nex][ney] || map[nex][ney] == 'T') continue;
            visited[nex][ney] = true;
            dfs(nex,ney, m+1);
            visited[nex][ney] = false;


        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        visited[R-1][0] = true;
        dfs(R-1, 0, 1);
        bw.write(ans+"");
        bw.flush();
        bw.close();
        br.close();

    }

}