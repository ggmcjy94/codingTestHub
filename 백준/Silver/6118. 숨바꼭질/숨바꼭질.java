import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {

    static int N,M, C,K;
    static int destination,distance,cnt;
    static int[][] map;
    static int[][] copyMap;
    static boolean[] visited;
    static ArrayList<Integer> arr[];
    static int[] dx = {0 , 1};
    static int[] dy = {1 , 0};

    //6 7
    //3 6
    //4 3
    //3 2
    //1 3
    //1 2
    //2 4
    //5 2

    //4 2 3
    static void bfs() {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0});
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int now = poll[0];
            int nex = poll[1];

            if (nex > distance) {
                distance = nex;
                destination = now;
                cnt = 1;
            } else if (nex == distance) {
                if (destination > now) destination = now;
                cnt++;
            }


            for (int i = 0; i < arr[now].size(); i++) {
                int next = arr[now].get(i);

                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(new int[] {next, nex+1});
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
        arr = new ArrayList[N+1];
        visited = new boolean[N+1];
        for (int i = 0; i <= N; i++) arr[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s].add(e);
            arr[e].add(s);
        }

        bfs();
        bw.write(destination +" " + distance + " "+ cnt);
        bw.flush();
        bw.close();
        br.close();
    }

}