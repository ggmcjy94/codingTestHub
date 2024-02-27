import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int T,N,C,V,S,E,M,Q,K,min,max;
    static long ans;
    static int[][] dis;
    static int[] arr,nums,operator,order;
    static int[] selected,used;
    static int[] dp,A;
    static int dx[] = {0, -1, 0 ,1};
    static int dy[] = {1, 0, -1, 0};

    static ArrayList<ArrayList<Integer>> graph;
    static boolean[][] visited,possible;
    static boolean[][][] visit;
    static int[] apart = new int[25*25];
    static int apartNum = 0;
    static StringBuilder sb = new StringBuilder();

    static void bfs(int x, int y) {
       Queue<int[]> queue = new LinkedList<>();
       queue.add(new int[]{x,y});
       visited[x][y] = true;
       while (!queue.isEmpty()) {
           int[] poll = queue.poll();
           int nowx = poll[0];
           int nowy = poll[1];

           for (int i = 0; i<4; i++) {
               int nex = nowx + dx[i];
               int ney = nowy +dy[i];
               if (nex<0 || ney < 0 || nex >= N || ney >= M)  continue;
               if (dis[nex][ney] != 0 && !visited[nex][ney]) {
                   queue.add(new int[]{nex,ney});
                   visited[nex][ney] = true;
                   dis[nex][ney] += dis[nowx][nowy];
               }
           }

       }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dis= new int[N][M];
        for (int i = 0; i< N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                dis[i][j] = s.charAt(j) -'0';
            }
        }
        visited = new boolean[N][M];

        for (int i = 0; i<N; i++) {
            for (int j = 0; j < M; j++) {
                if (dis[i][j] != 0 && !visited[i][j]) {
                    bfs(i,j);
                }
            }
        }
        bw.write(dis[N-1][M-1]+"");
        bw.flush();
        bw.close();
        br.close();
    }

}
