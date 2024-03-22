import java.io.*;
import java.util.*;

public class Main {

    static int N,M,C,R,T,A,B;
    static int ans;
    static StringTokenizer st;
    static int[] dx = {1,0,-1,0,1,-1,-1,1};
    static int[] dy = {0,1,0,-1,1,1,-1,-1};
    static int[][] arr, brr;
    static ArrayList<Integer>[] graph;
    static char[][] map;
    static Queue<int[]> iceQueue;
    static boolean[][] visited;
    static boolean[] visit;
    static int[] dist;
    static StringBuilder sb = new StringBuilder();
    static void full() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] = 'O';
            }
        }
    }

    static void boom(){
        int[] dx = new int[]{1,0,-1,0};
        int[] dy = new int[]{0,1,0,-1};
        boolean[][] visited = new boolean[R][C];
        int cnt = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'O') {
                    cnt++;
                    visited[i][j] = true;
                    for (int k = 0; k < 4; k++) {
                        int nex = i + dx[k];
                        int ney = j + dy[k];
                        if (nex < 0 || ney <0 || nex >= R || ney >= C) continue;
                        if (visited[nex][ney]) continue;
                        visited[nex][ney] = true;
                    }
                }
            }
        }
        if(cnt > 0) {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j<C; j++) {
                    if (visited[i][j]) map[i][j] = '.';
                    else map[i][j] = 'O';
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String val = br.readLine();
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String target = st.nextToken();
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cnt = 0;
            for (int j = start; j <= end; j++) {
                if (val.charAt(j) == target.charAt(0)) cnt++;
            }
            bw.write(cnt+"\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }

}

