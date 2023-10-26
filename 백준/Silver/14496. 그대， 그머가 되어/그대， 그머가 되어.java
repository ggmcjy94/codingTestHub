import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br;
    static BufferedWriter bw;
    static int T, N ,M,H, a,b;
    static int R ,C;
    static List<ArrayList<Integer>> graph = new ArrayList<>();
    static int[][] arr;
    static char[][] s_arr;
    static int[][][] t_arr;
    static boolean[] visit;
    static boolean[][] visited;
    static boolean[][][] t_visited;
    static int cnt1, cnt2;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    static int[] dx2 = {1,0,-1,0,0,0};
    static int[] dy2 = {0,1,0,-1,0,0};
    static int[] dh2 = {0,0,0,0,1,-1};

    static int res = Integer.MIN_VALUE;
    private static int bfs(int a) {
        Queue<int[]> queue = new LinkedList<>();
        visit[a] = true;
        queue.add(new int[]{a, 0});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (now[0] == b) {
                return now[1];
            }
            for (Integer next : graph.get(now[0])) {
                if (visit[next]) continue;
                visit[next] = true;
                queue.add(new int[]{next, now[1]+1});
            }
        }
        return -1;

    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine()," ");
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visit = new boolean[N+1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int aw = Integer.parseInt(st.nextToken());
            int bw = Integer.parseInt(st.nextToken());
            graph.get(aw).add(bw);
            graph.get(bw).add(aw);
        }

        bw.write(bfs(a)+"");
        //1 2
        //4 4
        //1 3
        //1 4
        //3 2
        //4 2
        //2

        //2 3
        //3 3
        //1 2
        //1 3
        //3 2
        //1
        bw.flush();
        bw.close();
    }
}