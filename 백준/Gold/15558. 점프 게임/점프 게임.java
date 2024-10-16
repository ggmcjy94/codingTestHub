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
    static PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
    //기본) 스택,큐,우선순위큐,Deque(★),해시맵,문자열
    //초급) PriorityQueue 완전탐색
    //중급) BinarySearch DFS BFS Recursion
    //심화) Graph Dp
    static class Jump {
        int a, b, c;
        public Jump(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    //7 3
    //1110110
    //1011001
    static void bfs(int x, int y) {
        Queue<Jump> jumps = new LinkedList<>();
        jumps.offer(new Jump(x, y, 0));

        while (!jumps.isEmpty()) {
            Jump poll = jumps.poll();
            if (poll.b >= N) {
                cnt = 1;
                break;
            }
            if (!visited[poll.a][poll.b+1]) {
                visited[poll.a][poll.b+1] = true;
                jumps.offer(new Jump(poll.a, poll.b+1, poll.c +1 ));
            }
            if (poll.b-1 > poll.c && !visited[poll.a][poll.b-1]) {
                visited[poll.a][poll.b-1] = true;
                jumps.offer(new Jump(poll.a, poll.b-1, poll.c +1 ));
            }
            if (!visited[1-poll.a][poll.b+K]) {
                visited[1-poll.a][poll.b+K] = true;
                jumps.offer(new Jump(1-poll.a,poll.b+K, poll.c +1 ));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[2][N+1+K];

        for (int i = 0; i < 2; i++) {
            String be = br.readLine();
            for (int j = 0; j <N; j++) {
                if (be.charAt(j) == '0') {
                    visited[i][j]= true;
                }
            }
        }
        if (visited[0][0]) {
            cnt = 0;
        } else {
            bfs(0, 0);
        }
        bw.write(cnt+"");
        bw.flush();
        bw.close();
        br.close();
    }
}