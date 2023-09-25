import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br;
    static BufferedWriter bw;
    static int[][] arr;
    static boolean[] visited;
    static int[] result;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int N,M,r,g,b;
    static int max = 100000;
    static int min_count = Integer.MAX_VALUE;
//5
//RRRBB
//GGBBB
//BBBRR
//BBRRR
//RRRRR
// 적록색약이 아닌 사람이 봤을 때 구역의 수는 총 4개이다. (빨강 2, 파랑 1, 초록 1)
// 하지만, 적록색약인 사람은 구역을 3개 볼 수 있다. (빨강-초록 2, 파랑 1)
    static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(N, 0));
        while (!queue.isEmpty()){
            Node poll = queue.poll();
            visited[poll.x] = true;
            if (poll.x == M) min_count = Math.min(min_count, poll.t);
            if (poll.x * 2 <= max && !visited[poll.x * 2]) queue.add(new Node(poll.x * 2 , poll.t));
            if (poll.x + 1  <= max && !visited[poll.x + 1]) queue.add(new Node(poll.x +1 , poll.t + 1));
            if (poll.x - 1  >= 0 && !visited[poll.x - 1]) queue.add(new Node(poll.x -1 , poll.t + 1));
        }
    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[max+1];
        bfs();
        bw.write(min_count+"");
        bw.flush();
        bw.close();
    }

    static class Node{
        int x , t;

        public Node(int x, int t) {
            this.x = x;
            this.t = t;
        }
    }
}