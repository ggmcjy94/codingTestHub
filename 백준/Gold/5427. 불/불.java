import java.io.*;
import java.util.*;

public class Main {

    static int T,N ,M ,ans;
    static char[][] map;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0 ,-1,1};
    static Queue<int[]> fireQueue;
    static Queue<int[]> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for (int e = 0; e<T;e++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            map = new char[N][M];
            queue = new LinkedList<>();
            fireQueue = new LinkedList<>();

            for (int  i = 0; i < N; i++) {
                String s = br.readLine();
                for (int j = 0; j < M; j++) {
                    map[i][j] = s.charAt(j);
                    if (map[i][j] =='@') queue.add(new int[]{i, j, 0});
                    if (map[i][j] == '*') fireQueue.add(new int[]{i, j, 0});
                }
            }
            ans = 0;
            bfs();
            if (ans == 0) {
                bw.write("IMPOSSIBLE\n");
            } else {
                bw.write(ans+"\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            int size = fireQueue.size();

            for (int i = 0; i < size; i++) {
                int[] poll = fireQueue.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = poll[0] + dx[j];
                    int ny = poll[1] + dy[j];
                    if (nx < 0 || ny < 0 || nx >=N || ny >= M)continue;
                    if (map[nx][ny] =='.' || map[nx][ny] =='@') {
                        map[nx][ny] = '*';
                        fireQueue.offer(new int[]{nx,ny, 0});
                    }
                }
            }

            size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = poll[0] + dx[j];
                    int ny = poll[1] + dy[j];
                    if (!(nx>=0 && ny>=0 && nx<N && ny<M)) {
                        ans = poll[2] + 1;
                        return;
                    }
                    if (map[nx][ny] =='.') {
                        map[nx][ny] = '@';
                        queue.offer(new int[]{nx,ny , poll[2]+1});
                    }
                }
            }
        }
    }


}