import java.io.*;
import java.util.*;

public class Main {

    static int N,M,T;
    static int[][] map;
    static int[] dy = { 1, 0, -1, 0 };
    static int[] dx = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(br.readLine());
        map = new int[M+1][N+1];
        StringBuilder sb = new StringBuilder();
        if (T > N * M ){
            sb.append("0");
        } else {
            int dir = 0;
            int x = 1, y = 1;
            int num = 1;
            while (num <= N * M) {
                map[y][x] = num++;
                if (num - 1 == T) {
                    sb.append(x).append(" ").append(y);
                    break;
                }
                if (x + dx[dir] < 1 || x + dx[dir] > N || y + dy[dir] < 1 || y + dy[dir] > M || map[y + dy[dir]][x + dx[dir]] != 0) {
                    dir++;
                    if (dir == 4){
                        dir = 0;
                    }
                }
                x = x + dx[dir];
                y = y + dy[dir];
            }
        }
        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}