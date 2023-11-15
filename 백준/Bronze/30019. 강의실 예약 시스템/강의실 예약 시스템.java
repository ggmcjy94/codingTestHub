
import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br;
    static BufferedWriter bw;
    static int N,M;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {1, 0 , -1, 0};
    static int[] dy = {0, 1 , 0, -1};
    static int max,count = 0;

    static void bfs(int x , int y) {

    }
    static class Classes {
        int s,e;

        public Classes( int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        Map<Integer,Classes> map = new HashMap<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            if (map.size() == 0) {
                sb.append("YES\n");
                map.put(r, new Classes(s,e));
                continue;
            }
            if (map.get(r) == null) {
                sb.append("YES\n");
                map.put(r, new Classes(s,e));
                continue;
            }
            if (map.get(r).e <= s){
                sb.append("YES\n");
                map.put(r, new Classes(s,e));
                continue;
            }
            sb.append("NO\n");
        }
        bw.write(sb+"");
        bw.flush();
        bw.close();
    }
}