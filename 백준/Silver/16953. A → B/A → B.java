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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int res = 1;
        while (B != A) {
            if (B < A) break;
            if (B % 10 == 1) {
                B /=10;
            } else if (B % 2 == 0) {
                B /= 2;
            } else {
                break;
            }
            res++;
        }

        if (B == A) {
            bw.write(res+"");
        } else {
            bw.write("-1");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}