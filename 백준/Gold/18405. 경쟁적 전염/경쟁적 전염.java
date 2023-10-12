import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br;
    static BufferedWriter bw;

    static List<List<Integer>> graph = new ArrayList<>();
    static int[][] arr;
    static boolean[] visit;
    static boolean[][] visited;
    static int[] checked;
    static int N , K, s,x,y;
    static int cnt = 1;
    static boolean chek;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static Queue<Node> q = new LinkedList<>();
    static class Node{
        int x;
        int y;
        int virus;
        int time;

        public Node(int x, int y, int virus, int time) {
            this.x = x;
            this.y = y;
            this.virus = virus;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        //경쟁적 전염
        //3 3
        //1 0 2
        //0 0 0
        //3 0 0
        //2 3 2
        st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        ArrayList<Node> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(),  " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] != 0) {
                    list.add(new Node(i, j, arr[i][j], 0));
                }
            }
        }

        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.virus - o2.virus;
            }
        });

        for (Node node : list) {
            q.add(node);
        }

        st = new StringTokenizer(br.readLine(), " ");
        s = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        bfs();

        bw.write(arr[x-1][y-1]+"");
        bw.flush();
        bw.close();
    }

    static void bfs() {
        while (!q.isEmpty()) {
            Node now = q.poll();
            int x = now.x;
            int y = now.y;
            if (now.time == s) {
                return;
            }
            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                    if (arr[nx][ny] == 0) {
                        arr[nx][ny] = now.virus;
                        q.add(new Node(nx, ny, now.virus, now.time + 1));
                    }
                }
            }

        }
    }
}
