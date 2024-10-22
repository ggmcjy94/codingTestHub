import java.io.*;
import java.util.*;

public class Main {
    static int N,M,K;
    static int x, y;
    static int[][] arr, cop;
    static int[] basic;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int cnt;
    //기본) 스택,큐,우선순위큐,Deque(★),해시맵,문자열
    //초급) PriorityQueue 완전탐색
    //중급) BinarySearch DFS BFS Recursion
    //심화) Graph Dp



    //70 85 30 50 60 60 50

    //35 43 30 17 40 30 50

    //


    static class Study implements Comparable<Study>{
        int a, b;

        public Study(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Study o) {
            return o.b - this.b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = N * 24;


        //8 7 192
        //30 15 70 50 40 40 50
        //2  2  1  3  1  2  1
        basic = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M ; i++) {
            int aa = Integer.parseInt(st.nextToken());
            basic[i] = aa;
        }
        PriorityQueue<Study> studies = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M ; i++) {
            int aa = Integer.parseInt(st.nextToken());
            studies.offer(new Study(i,aa));
        }

        //1 2
        //50 60
        //4 3


        //8 7
        //30 15 70 50 40 40 50
        //2 2 1 3 1 2 1
        while (K > 0 && !studies.isEmpty()) {
            Study p = studies.poll();
            int time = ((100 - basic[p.a]) / p.b);
            int realTime = Math.min(K, time);
            K -= realTime;
            basic[p.a] += p.b * realTime;

            if(basic[p.a] != 100) {
                studies.add(new Study(p.a, 100 - basic[p.a]));
            }
        }


        int answer = 0;
        for (int i = 0; i < M; i++) {
            answer += basic[i];
        }

        System.out.println(answer);
        bw.flush();
        bw.close();
        br.close();
    }
}