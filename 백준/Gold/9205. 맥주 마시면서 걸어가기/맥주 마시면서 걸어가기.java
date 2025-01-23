import java.io.*;
import java.util.*;

public class Main {

    static int N ,T, hx,hy,rx,ry;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t  <  T; t++) {
            N = Integer.parseInt(br.readLine());
            List<int[]> list = new ArrayList<>();
            for (int i = 0; i < N+2; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                if (i == 0) {
                    hx = x;
                    hy = y;
                } else if (i == N+1) {
                    rx = x;
                    ry = y;
                } else {
                    list.add(new int[] {x,y});
                }
            }
            boolean bfs = bfs(list);
            if (bfs) {
                bw.write("happy\n");
            } else {
                bw.write( "sad\n");
            }

        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static boolean bfs(List<int[]> list) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[N];
        queue.add(new int[] {hx,hy});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int px = poll[0];
            int py = poll[1];

            if (Math.abs(px-rx) + Math.abs(py-ry) <= 1000) {
                return true;
            }

            for (int i = 0; i < N; i++) {
                if (!visited[i]) {
                    int nx = list.get(i)[0];
                    int ny = list.get(i)[1];
                    int dis = Math.abs(px - nx) + Math.abs(py - ny);
                    if(dis <= 1000) {
                        visited[i] = true;
                        queue.add(new int[]{nx,ny});
                    }
                }
            }
        }
        return false;
    }
}