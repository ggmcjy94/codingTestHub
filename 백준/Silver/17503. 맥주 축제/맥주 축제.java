import java.io.*;
import java.util.*;

public class Main {
    static int N,K;
    static long M;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int cnt;
    //기본) 스택,큐,우선순위큐,Deque(★),해시맵,문자열
    //초급) PriorityQueue 완전탐색
    //중급) BinarySearch DFS BFS Recursion
    //심화) Graph DP


    static class Beer implements Comparable<Beer>{
        int v, k;

        public Beer(int v, int k) {
            this.v = v;
            this.k = k;
        }

        @Override
        public int compareTo(Beer o) {
            return this.k - o.k;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        List<Beer> beers = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            beers.add(new Beer(v,k));
        }
        Collections.sort(beers);

        //3 9 5
        //2 5
        //4 6
        //3 3
        //4 3
        //1 4

        //3 3
        //4 3
        //1 4
        //2 5
        //4 6
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        int res =0;
        int sum = 0;
        for (Beer beer : beers) {
            queue.offer(beer.v);
            sum += beer.v;

            if (queue.size() > N) {
                sum -= queue.poll();
            }

            if (queue.size() == N && sum >= M) {
                res = beer.k;
                break;
            }
        }

        if (res == 0) {
            bw.write("-1");
        } else {
            bw.write(res + "");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}