import java.io.*;
import java.util.*;

public class Main {
    static int result;
    static char[][] map;
    static char[] move;
    static boolean[][] visited;
    static int N,M,a,b;

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st; 
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j< M; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken())-1;
        b = Integer.parseInt(st.nextToken())-1;
        String move = br.readLine();        
        
        for (int i = 0; i < move.length(); i++) {
            if (move.charAt(i) =='W') {
                bfs(a,b);
            }
            if (move.charAt(i) == 'U') {
                if (a==0) continue;
                a = a-1;
            }
            if (move.charAt(i) == 'D') {
                if (a==N-1) continue;
                a = a+1;
            }
            if (move.charAt(i) == 'L') {
                if (b==0) continue;
                b = b-1;
            }
            if (move.charAt(i) == 'R') {
                if (b==M-1) continue;
                b = b+1;
            }
        }
        visited[a][b] = true;
        for (int i = 0; i < 4; i++) {
            int aa = a+dx[i];
            int bb = b+dy[i];
            if (aa < 0 || bb < 0 || aa>= N || bb>=M || visited[aa][bb]) continue;
            visited[aa][bb] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j]) {
                    sb.append(".");
                } else {
                    sb.append("#");
                }
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs (int r, int c) {
       Queue<int[]> queue = new LinkedList<>();
       queue.offer(new int[] {r,c}); 
       visited[r][c] =true;

       while(!queue.isEmpty()) {
        int[] pol = queue.poll();
        int nx = pol[0];
        int ny = pol[1];
        for (int i = 0;  i < 4; i++) {
            int nex = nx + dx[i];
            int ney = ny + dy[i];
            if (nex < 0 || ney < 0 || nex >= N || ney >= M || visited[nex][ney]) continue;    
            if (map[r][c] == map[nex][ney]) {
                queue.offer(new int[]{nex,ney});
                visited[nex][ney] = true;
            }
        }
       }
    }
}