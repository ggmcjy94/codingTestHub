import java.io.*;
import java.util.*;

public class Main {

    static int N, L,R;
    static int[][] arr;
    static int[][] copyMap;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][] visited;
    static int max,cnt;
    static Queue<int[]> queue = new LinkedList<>();
    static List<Pos> list;



    static class Pos {
        int x, y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    // (50+30+30) / 3 = 36
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            boolean move = false;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        int sum = bfs(i, j);
                        if (list.size() > 1) {
                            for (Pos pos : list) {
                                arr[pos.x][pos.y] = sum/list.size();
                                move = true;
                            }

                        }

                    }
                }
            }

            if (!move) {
                break;
            }
            cnt++;
        }

        bw.write(cnt+"");
        bw.flush();
        bw.close();
        br.close();

    }


    //4 10 50
    //10 100 20 90
    //80 100 60 70
    //70 20 30 40
    //50 20 100 10

    static int bfs (int r, int c) {
        queue.offer(new int[]{r,c});
        visited[r][c] = true;
        int sum = arr[r][c];
        list = new ArrayList<>();
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nox = poll[0];
            int noy = poll[1];
            list.add(new Pos(nox,noy));
            for (int i = 0; i < 4; i++) {
                int nex = nox + dx[i];
                int ney = noy + dy[i];
                if (nex < 0 || nex >= N || ney < 0 || ney >= N) continue;
                if (visited[nex][ney]) continue;
                int diff = Math.abs(arr[nox][noy] - arr[nex][ney]);
                if (diff >= L && diff <= R) {
                    queue.offer(new int[]{nex,ney});
                    sum += arr[nex][ney];
                    visited[nex][ney] = true;
                }
            }
        }
        return sum;
    }
 }