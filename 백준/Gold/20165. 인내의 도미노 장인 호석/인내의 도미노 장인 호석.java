import java.io.*;
import java.util.*;

public class Main {
    static int N,M,R,min,max, ans;
    static int[][] arr;
    static int[][] backUp;

    static int[] nums , operator, order, col;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static Queue<int[]> queue = new LinkedList<>();
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();

    static int get_odd_cnt(int x) {
        int res =0;
        while (x > 0) {
            int digit = x %10;
            if (digit % 2 == 1) res++;
            x /= 10;
        }
        return res;
    }
    //5 5 3
    //1 1 1 1 1
    //1 2 2 1 1
    //3 1 2 2 2
    //1 3 2 1 1
    //1 3 3 1 1

    //s f s s s
    //s f s s s
    //s f s f s
    //s f f s s
    //s f f s s

    static void dfs(int x , int total_odd_cnt){
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N+1][M+1];
        backUp = new int[N+1][M+1];
        for (int i = 1; i <=N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= M; j++) {
                int s = Integer.parseInt(st.nextToken());
                arr[i][j] = s;
                backUp[i][j] = s;
            }
        }

        List<Player> playerList = new ArrayList<>();
        for (int i =0; i < R; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            char sd  = st.nextToken().charAt(0);
            st= new StringTokenizer(br.readLine(), " ");
            int dx = Integer.parseInt(st.nextToken());
            int dy = Integer.parseInt(st.nextToken());
            playerList.add(new Player(sx,sy,dx,dy,sd));
        }
        for (Player player : playerList) {
            domino(player);
            arr[player.dx][player.dy] = backUp[player.dx][player.dy];
        }
        bw.write(ans+"\n");
        for (int i = 1; i<=N; i++) {
            for (int j = 1; j  <=M; j++) {
                if (arr[i][j] > 0) bw.write("S ");
                else bw.write("F ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void domino(Player player) {
        int cnt = arr[player.sx][player.sy];
        if (player.sd == 'E') {
            for (int i = player.sy; i<= M; i++) {
                if (cnt <= 0) {
                    break;
                } else if (arr[player.sx][i] <= cnt) {
                    cnt--;
                    if (arr[player.sx][i] != 0) {
                        ans++;
                    }
                    arr[player.sx][i] = 0;


                } else if (arr[player.sx][i] > cnt){
                    cnt = arr[player.sx][i]-1;
                    if (arr[player.sx][i] != 0) {
                        ans++;
                    }
                    arr[player.sx][i] = 0;

                }
            }

        }
        if (player.sd == 'W') {
            for (int i = player.sy; i >= 1; i--) {
                if (cnt <= 0) {
                    break;
                } else if (arr[player.sx][i] <= cnt) {
                    cnt--;
                    if (arr[player.sx][i] != 0) {
                        ans++;
                    }
                    arr[player.sx][i] = 0;

                } else if (arr[player.sx][i] > cnt){
                    cnt = arr[player.sx][i]-1;
                    if (arr[player.sx][i] != 0) {
                        ans++;
                    }
                    arr[player.sx][i] = 0;

                }
            }
        }
        if (player.sd == 'S') {
            for (int i = player.sx; i <= N; i++) {
                if (cnt <= 0) {
                    break;
                } else if (arr[i][player.sy] <= cnt) {
                    cnt--;
                    if (arr[i][player.sy] != 0) {
                        ans++;
                    }
                    arr[i][player.sy] = 0;

                } else if (arr[i][player.sy] > cnt){
                    cnt = arr[i][player.sy]-1;
                    if (arr[i][player.sy] != 0) {
                        ans++;
                    }
                    arr[i][player.sy] = 0;

                }
            }
        }
        if (player.sd == 'N') {
            // 3 2 0 2 1
            // 3 1
            for (int i = player.sx; i >= 1; i--) {
                if (cnt <= 0) {
                    break;
                } else if (arr[i][player.sy] <= cnt) {
                    cnt--;
                    if (arr[i][player.sy] != 0) {
                        ans++;
                    }
                    arr[i][player.sy] = 0;
                } else if (arr[i][player.sy] > cnt){
                    cnt = arr[i][player.sy]-1;
                    if (arr[i][player.sy] != 0) {
                        ans++;
                    }
                    arr[i][player.sy] = 0;
                }
            }
        }


    }


    static class Player{
        int sx,sy,dx,dy;
        char sd;

        public Player(int sx, int sy, int dx, int dy, char sd) {
            this.sx = sx;
            this.sy = sy;
            this.dx = dx;
            this.dy = dy;
            this.sd = sd;
        }
    }
}
