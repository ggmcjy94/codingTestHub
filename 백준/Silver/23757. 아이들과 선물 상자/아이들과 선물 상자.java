import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[] selected, arr;
    static int[][] map;
    static boolean[] used;
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();
    static int white = 0;
    static int blue = 0;
    //기본) 스택,큐,우선순위큐,Deque(★),해시맵,문자열
    //초급) PriorityQueue 완전탐색
    //중급) BinarySearch DFS BFS Recursion
    //심화) Graph DP


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> gifts = new PriorityQueue<>(Collections.reverseOrder());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N ; i++) {
            gifts.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        boolean flag = false;
        for (int i = 0; i < M ; i++) {
            int val = Integer.parseInt(st.nextToken());
            if (gifts.peek() >= val) {
                gifts.add(gifts.peek() - val);
                gifts.poll();
            } else {
                flag = true;
            }
        }
        
        if (flag) {
            bw.write("0");
        } else {
            bw.write("1");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
