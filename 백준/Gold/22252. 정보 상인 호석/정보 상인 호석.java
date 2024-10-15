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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        //7
        //1 Cpp 5 10 4 2 8 4
        //1 Java 2 8 2
        //2 Cpp 2
        //1 Cpp 2 10 3
        //2 Cpp 3
        //2 Java 1
        //2 Python 10
        K = Integer.parseInt(br.readLine());
        Map<String, PriorityQueue<Integer>> map = new HashMap<>();
        long sum  = 0;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int i1 = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            int i2 = Integer.parseInt(st.nextToken());
            if (i1 == 1) {
                for (int j = 0; j < i2; j++) {
                    if (!map.containsKey(s)) {
                        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
                        int i3 = Integer.parseInt(st.nextToken());
                        pq.offer(i3);
                        map.put(s,pq);
                    } else {
                        map.get(s).offer(Integer.parseInt(st.nextToken()));
                    }
                }
            } else {
                if (map.get(s) == null) continue;
                PriorityQueue<Integer> priorityQueue1 = map.get(s);
                while (!priorityQueue1.isEmpty() && i2 > 0) {
                    sum += priorityQueue1.poll();
                    i2--;
                }
            }
        }
        bw.write(sum+"");
        bw.flush();
        bw.close();
        br.close();
    }
}