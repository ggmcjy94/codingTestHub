import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static char[][] map;
    static boolean[][][] visited;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = 12;
        M = 6;
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        while (true) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j<M; j++ ) {
                    if (map[i][j] == 'Y' || map[i][j] == 'G' || map[i][j] == 'R' || map[i][j] == 'B' || map[i][j] == 'P') {
                        cnt += bfs(i, j, map[i][j]);
                    }

                }
            }

            if (cnt > 1) {
                cnt=1;
            }
            for (int i = N-1; i >= 0; i--) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 'Y' || map[i][j] == 'G' || map[i][j] == 'R' || map[i][j] == 'B' || map[i][j] == 'P') {
                        int c = 0;
                        for (int k = i+1; k < N; k++) {
                            if (map[k][j] == '.') {
                                c = k;
                            }
                        }
                        if (c > 0) {
                            map[c][j] = map[i][j];
                            map[i][j] = '.';
                        }
                    }
                }
            }
            if (cnt == 0) {
                break;
            } else {
                res += cnt;
            }
        }
        bw.write(res+"");
        bw.flush();
        bw.close();
        br.close();
    }

    private static int bfs(int x, int y, char target) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visit = new boolean[N][M];
        queue.offer(new int[]{x,y});
        visit[x][y] = true;
        List<int[]> list =  new ArrayList<>();
        list.add(new int[]{x,y});
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nx = poll[0];
            int ny = poll[1];
            for (int i = 0; i < 4 ; i++) {
                int nex = nx + dx[i];
                int ney = ny + dy[i];
                if (nex < 0 || ney < 0 || nex >= N || ney >= M || visit[nex][ney]) continue;
                if (map[nex][ney] == target) {
                    queue.offer(new int[]{nex,ney});
                    visit[nex][ney] = true;
                    list.add(new int[]{nex,ney});
                }
            }
        }
        if (list.size() >= 4) {
            for (int[] ints : list) {
                map[ints[0]][ints[1]] = '.';
            }
            return 1;
        }
        return 0;
    }
}