import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int T,N,C,V,S,E,M,Q,K,R,min,max;
    static long ans;
    static int[][] dis;
    static char[][] map;
    static int[] arr,nums,operator,order,dist;
    static int[] selected,used;
    static int[] dp,A;
    static int dx[] = {0, -1, 0 ,1};
    static int dy[] = {1, 0, -1, 0};

    static ArrayList<ArrayList<Integer>> graph;
    static boolean[][] visited,possible;
    static boolean[][][] visit;
    static StringBuilder sb = new StringBuilder();

    static int[][] dist_water, dist_hedgehog;

    static void waterBfs() {
        Queue<int[]> waterQueue = new LinkedList<>();
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                dist_water[i][j] = -1;
                if (map[i][j] == '*') {
                    waterQueue.add(new int[]{i, j});
                    visited[i][j] = true;
                    dist_water[i][j] = 0;
                }
            }
        }

        while (!waterQueue.isEmpty()) {
            int[] poll = waterQueue.poll();
            int nox = poll[0];
            int noy = poll[1];
            for (int i = 0; i<4; i++) {
                int nex = nox + dx[i];
                int ney = noy + dy[i];
                if (nex < 0 || nex >= R || ney < 0 || ney >= C) continue;
                if (map[nex][ney] != '.') continue;
                if (visited[nex][ney]) continue;
                waterQueue.add(new int[] {nex, ney});
                visited[nex][ney] = true;
                dist_water[nex][ney] = dist_water[nox][noy] + 1;
            }
        }


    }

    static void hackDogBfs() {
        Queue<int[]> hackDogQueue = new LinkedList<>();
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            for (int j= 0; j < C; j++) {
                visited[i][j] = false;
                dist_hedgehog[i][j] = -1;
                if (map[i][j] == 'S') {
                    hackDogQueue.add(new int[]{i,j});
                    dist_hedgehog[i][j] = 0;
                    visited[i][j] = true;
                }
            }
        }


        while (!hackDogQueue.isEmpty()) {
            int[] poll = hackDogQueue.poll();
            int nox = poll[0];
            int noy = poll[1];
            for (int i = 0; i < 4; i++) {
                int nex = nox + dx[i];
                int ney = noy + dy[i];

                if (nex < 0 || ney < 0 || nex>=R || ney >= C) continue;
                if (map[nex][ney] != '.' && map[nex][ney] != 'D') continue;
                if (dist_water[nex][ney] != -1 && dist_water[nex][ney] <= dist_hedgehog[nox][noy] + 1) continue;
                if (visited[nex][ney]) continue;
                hackDogQueue.add(new int[]{nex, ney});
                visited[nex][ney] = true;
                dist_hedgehog[nex][ney] = dist_hedgehog[nox][noy] + 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        dist_water = new int[R][C];
        dist_hedgehog = new int[R][C];
        waterBfs();
        hackDogBfs();
        for (int i = 0;i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'D') {
                    if (dist_hedgehog[i][j] == -1) {
                        bw.write("KAKTUS");
                    }
                    else {
                        bw.write(dist_hedgehog[i][j]+"");
                    }
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
