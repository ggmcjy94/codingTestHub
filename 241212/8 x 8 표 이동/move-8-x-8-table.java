import java.io.*;
import java.util.*;

public class Main {

    static int N , M, S;
    static char [][] map;
    static int[][] arr;
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    static List<int[]> wallList = new ArrayList<>();
    static     boolean[][] visited;

    static int bfs() {
        visited = new boolean[8][8];
        Queue<int[]> queue = new LinkedList<>();

        // 시작 위치 (7, 0) 추가
        queue.offer(new int[]{7, 0});
        visited[7][0] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                int nox = poll[0];
                int noy = poll[1];

                if (nox == 0 && noy == 7) {
                    return 1;
                }
                if (map[nox][noy] == '#') continue;
                for (int j = 0; j < 8; j++) {
                    int nex = nox + dx[j];
                    int ney = noy + dy[j];
                    if (nex >= 0 && nex < 8 && ney >= 0 && ney < 8 && !visited[nex][ney] && map[nex][ney] == '.') {
//                        System.out.println(nex + " : " + ney);
                        visited[nex][ney] = true;
                        queue.offer(new int[]{nex, ney});
                    }
                }
            }
            moveWalls();
        }
        return 0;
    }
    static void moveWalls() {
        for (int i = wallList.size()-1; i >= 0; i--) {
            int[] walls = wallList.get(i);
            int nox = walls[0];
            int noy = walls[1];
            int nex = nox + 1;
            if (nex < 8) {
                visited[nox][noy] = false;
                map[nox][noy] = '.';
                map[nex][noy] = '#';
            }
        }
        wallList.clear();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] =='#') {
                    wallList.add(new int[]{i, j});
                }
            }
        }

//        for (char[] chars : map) {
//            System.out.println();
//            for (char aChar : chars) {
//                System.out.print(aChar);
//            }
//        }
//        System.out.println();
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = 8;
        M = 8;
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
                if (map[i][j]=='#') {
                    wallList.add(new int[]{i,j});
                }
            }
        }
        bw.write(bfs()+"");
        bw.flush();
        bw.close();
        br.close();
    }

}