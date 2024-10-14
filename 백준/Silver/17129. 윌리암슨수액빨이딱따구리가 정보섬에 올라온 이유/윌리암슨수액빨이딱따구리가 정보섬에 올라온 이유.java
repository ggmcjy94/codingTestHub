import java.io.*;
import java.util.*;

public class Main {
    static int N,M,K;
    static int x, y;
    static int[][] arr, cop;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int cnt;
    static Queue<Point> queue = new LinkedList<>();
    //기본) 스택,큐,우선순위큐,Deque(★),해시맵,문자열
    //초급) PriorityQueue 완전탐색
    //중급) BinarySearch DFS BFS Recursion
    //심화) Graph Dp

    static class Point{
        int x;
        int y;
        int time;
        Point(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
    //3 3
    //200
    //003
    //045
    static void bfs() {
        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            if (arr[poll.x][poll.y] == 3 || arr[poll.x][poll.y] == 4 || arr[poll.x][poll.y] == 5){
                cnt = poll.time;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nex = dx[i] + poll.x;
                int ney = dy[i] + poll.y;
                if (nex < 0 || nex >= N || ney < 0 || ney >= M) continue;
                if (visited[nex][ney]) continue;
                if (arr[nex][ney] == 1) continue;
                queue.add(new Point(nex,ney,poll.time+1));
                visited[nex][ney] = true;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st=new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];
        cop = new int[N][M];
        for (int i = 0; i < N; i++) {
            String be = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = be.charAt(j) - '0';
                if (arr[i][j] == 2) {
                    queue.offer(new Point(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }
        bfs();
        if (cnt == 0) {
            bw.write("NIE");
        } else {
            bw.write("TAK"+"\n"+cnt);
        }

//        bw.write(cnt+"");
        bw.flush();
        bw.close();
        br.close();
    }
}