import java.io.*;
import java.util.*;

public class Main {

    static int L,R ,C;
    static char[][][] map;
    static StringBuilder sb = new StringBuilder();
    static int[] dx= {-1,1,0,0,0,0};
    static int[] dy = {0,0,-1,1,0,0};
    static int[] dz = {0,0,0,0,1,-1};
    //3 4 5
    //S....
    //.###.
    //.##..
    //###.#
    //
    //#####
    //#####
    //##.##
    //##...
    //
    //#####
    //#####
    //#.###
    //####E
    //
    //1 3 3
    //S##
    //#E#
    //###
    //
    //0 0 0

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            if (L==0&&R==0&&C==0) {
                bw.write(sb.toString());
                break;
            }

            map = new char[L][R][C];

            int sx=0,sy=0,sz=0;
            for (int i = 0; i < L ; i++) {
                for (int j = 0; j < R; j++) {
                    String s = br.readLine();
                    for (int k = 0; k < C; k++) {
                        map[i][j][k] = s.charAt(k);
                        if(map[i][j][k] == 'S') {
                            sx =i; sy = j; sz =k;
                            map[i][j][k] = '.';
                        }
                    }
                }
                br.readLine();
            }
            bfs(sx, sy, sz);
        }

        bw.flush();
        bw.close();
        br.close();
    }


    static void bfs(int x , int y , int z) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] check = new boolean[L][R][C];
        queue.add(new int[]{x, y, z, 0});
        check[x][y][z] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int px = poll[0], py = poll[1] , pz = poll[2];
            int move = poll[3];
            if (map[px][py][pz] == 'E') {
                sb.append("Escaped in " + move+" minute(s).\n");
                return;
            }

            for (int i = 0; i < 6; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];
                int nz = pz + dz[i];
                if(nx <0 || ny <0 || nz<0 || nx > L-1 || ny>R-1 || nz > C-1) continue;
                if (check[nx][ny][nz]) continue;
                if (map[nx][ny][nz] =='.' || map[nx][ny][nz] == 'E') {
                    check[nx][ny][nz] = true;
                    queue.add(new int[]{nx,ny,nz, move+1});
                }
            }
        }
        sb.append("Trapped!\n");

    }
}