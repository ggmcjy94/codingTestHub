import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[][] map;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int res = Integer.MAX_VALUE;
    static List<Virus> virusList;
    static Virus[] active;
    static int zeroCnt;
    static class Virus {
        int x, y , time;

        public Virus(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        active = new Virus[M];
        virusList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                 map[i][j] = Integer.parseInt(st.nextToken());
                 if (map[i][j] == 0) {
                     zeroCnt++;
                 } else if (map[i][j] == 2) {
                     virusList.add(new Virus(i, j , 0));
                 }

            }
        }


        if (zeroCnt == 0) {
            bw.write("0");
        } else {
            virus(0, 0);
            int i = res == Integer.MAX_VALUE ? -1 : res;
            bw.write( i+ "");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void virus(int s,int d) {
        if (d == M) {
            bfs(zeroCnt);
            return;
        }

        for (int i = s; i <  virusList.size(); i++) {
            active[d] = virusList.get(i);
            virus(i+1, d+1);
        }
    }


    private static void bfs(int zc) {
        Queue<Virus> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < M; i++) {
            Virus virus = active[i];
            visited[virus.x][virus.y] = true;
            queue.offer(virus);
        }

        while (!queue.isEmpty()) {
            Virus poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nex = poll.x + dx[i];
                int ney = poll.y + dy[i];
                if (nex < 0 || ney < 0 || nex >= N || ney >= N || visited[nex][ney] || map[nex][ney] == 1) continue;

                if (map[nex][ney] == 0) zc--;

                if (zc==0) {
                    res = Math.min(res, poll.time + 1);
                    return;
                }
                visited[nex][ney] = true;
                queue.add(new Virus(nex,ney, poll.time+1));
            }
        }
    }
}