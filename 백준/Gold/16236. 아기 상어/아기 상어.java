import java.io.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int[][] map;
    static int[][] copyMap;
    static boolean[][] visited;
    static PriorityQueue<Shark> pq = new PriorityQueue<Shark>();
    static int[] dx = {0 , 1 , 0 , -1};
    static int[] dy = {1 , 0 , -1, 0};

    static class Shark implements Comparable<Shark>{
        int x, y, dis;

        public Shark(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }

        @Override
        public int compareTo(Shark o) {
            if (this.dis != o.dis) return Integer.compare(this.dis, o.dis);
            else {
                if (this.x == o.x) return Integer.compare(this.y, o.y);
                else return Integer.compare(this.x, o.x);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        Queue<Shark> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    map[i][j] = 0;
                    queue.add(new Shark(i, j, 0));
                }
            }
        }



        bfs(queue, 2);
        int m=0,cnt=0,size=2;

        while (!pq.isEmpty()) {
            Shark poll = pq.poll();
            map[poll.x][poll.y] = 0;
            if (++cnt == size) {
                cnt = 0;
                size++;
            }
            m += poll.dis;
            queue = new LinkedList<>();
            queue.offer(new Shark(poll.x,poll.y,0));
            bfs(queue, size);
        }
        bw.write(m +"");
        bw.flush();
        bw.close();
        br.close();

    }

    private static void bfs(Queue<Shark> queue, int size) {
        //4
        //4 3 2 1
        //0 0 0 0
        //0 0 9 0
        //1 2 3 4
        pq = new PriorityQueue<>();
        visited = new boolean[N][N];
        while (!queue.isEmpty()) {
            Shark poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny>=N || map[nx][ny] > size || visited[nx][ny]) continue;
                visited[nx][ny] = true;
                queue.offer(new Shark(nx,ny, poll.dis+1));
                if (map[nx][ny] != 0 && map[nx][ny] < size) {
                    pq.offer(new Shark(nx,ny, poll.dis+1));
                }
            }
        }
    }
}