import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br;
    static BufferedWriter bw;
    static int[][] arr;
    static boolean[] visit;
    static int[] result;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int N,M,res;
    static int min_count = Integer.MAX_VALUE;
    //1과 3, 1과 4, 2와 3, 3과 4, 4와 5
    //5 5
    //1 3
    //1 4
    //4 5
    //4 3
    //3 2

    static class Ba{
        int num,value;

        public Ba(int num, int value) {
            this.num = num;
            this.value = value;
        }
    }
    static void bfs(int x) {
        Queue<Ba> queue = new LinkedList<>();
        int cnt = 0;

        visit[x] = true;
        queue.add(new Ba(x, 0));
        while (!queue.isEmpty()) {
            Ba poll = queue.poll();
            cnt += poll.value;

            for (int i =1; i<= N ; i++) {
                if (arr[poll.num][i] == 1 && !visit[i]) {
                    visit[i] = true;
                    queue.add(new Ba(i, poll.value+1));
                }
            }
        }
        if (min_count > cnt) {
            min_count = cnt;
            res = x;
        }
    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1][N+1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            arr[s][e]=1;
            arr[e][s]=1;
        }
        for (int i = 1; i <= N; i++) {
            visit = new boolean[N+1];
            bfs(i);
        }
        bw.write(res + "");
        bw.flush();
        bw.close();
    }
}