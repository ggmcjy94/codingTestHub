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
    //심화) Graph Dp


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int sum =0;
        PriorityQueue<Integer>[] position = new PriorityQueue[12];
        for (int i = 0; i < 12; i++) {
            position[i] = new PriorityQueue<>(Comparator.reverseOrder());
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            position[n].add(k);
        }
        for (int i = 0; i<K; i++) {
            for (int j = 1; j <= 11; j++) {
                if (!position[j].isEmpty() && position[j].peek() > 1) {
                    int value = position[j].poll();
                    position[j].add(value-1);
                }

            }
        }
        for (int j = 1; j <= 11; j++) {
           if (!position[j].isEmpty()) {
               sum += position[j].poll();
           }
        }
        bw.write(sum+"");
        bw.flush();
        bw.close();
        br.close();
    }
}