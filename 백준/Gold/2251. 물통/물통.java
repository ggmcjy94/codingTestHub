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
    static boolean[] visited,possible;
    static boolean[][][] visit;
    static int[] apart = new int[25*25];
    static int apartNum = 0;
    static StringBuilder sb = new StringBuilder();

    static class State{
        int[] X;

        public State(int[] x) {
            X = new int[3];
            for (int i = 0; i< 3; i++) X[i] = x[i];
        }

        private State move (int from, int to , int[] Limit) {
            int[] nX = {X[0], X[1], X[2]};
            if (X[from] + X[to] <= Limit[to]) {
                nX[to] = nX[from] + nX[to];
                nX[from] = 0;
            }else{
                nX[from] -= Limit[to] - nX[to];
                nX[to] = Limit[to];
            }
            return new State(nX);
        }
    }

    static void bfs(int x1, int x2, int x3) {
        Queue<State> Q = new LinkedList<>();
        visit[x1][x2][x3] = true;
        Q.add(new State(new int[]{x1, x2, x3}));

        while (!Q.isEmpty()) {
            State st = Q.poll();
            if (st.X[0] == 0) possible[st.X[2]] = true;
            for (int f = 0; f < 3; f++) {
                for (int t = 0; t < 3; t++) {
                    if (f == t) continue;
                    State nxt = st.move(f, t, arr);
                    if (!visit[nxt.X[0]][nxt.X[1]][nxt.X[2]]) {
                        visit[nxt.X[0]][nxt.X[1]][nxt.X[2]] = true;
                        Q.add(nxt);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        arr = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i<3; i++) arr[i] = Integer.parseInt(st.nextToken());
        visit = new boolean[205][205][205];
        possible = new boolean[205];

        bfs(0,0,arr[2]);
        for (int i=0;i<=200;i++){
            if (possible[i]) sb.append(i).append(' ');
        }
        System.out.println(sb);

        bw.flush();
        bw.close();
        br.close();
    }

}
