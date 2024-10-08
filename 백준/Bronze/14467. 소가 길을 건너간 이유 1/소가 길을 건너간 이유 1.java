import java.io.*;
import java.util.*;

public class Main {
    static int N;
    //기본) 스택,큐,우선순위큐,Deque(★),해시맵,문자열
    //초급) PriorityQueue 완전탐색
    //중급) BinarySearch DFS BFS Recursion
    //심화) Graph DP

    static class Cow{
        int lr,cnt;

        public Cow(int lr, int cnt) {
            this.lr = lr;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        //8
        //3 1
        //3 0
        //6 0
        //2 1
        //4 1
        //3 0
        //4 0
        //3 1
        N = Integer.parseInt(br.readLine());
        int[][] arr = new int[11][1];
        for (int i = 1; i < 11; i++) {
            arr[i][0] = -1;
        }
        int res = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cow = Integer.parseInt(st.nextToken());
            int lr = Integer.parseInt(st.nextToken());
            if (arr[cow][0] == -1) {
                arr[cow][0] = lr;
            } else {
                if (arr[cow][0] != lr) {
                    res++;
                    arr[cow][0] = lr;
                }
            }
        }
        bw.write(res+"");
        bw.flush();
        bw.close();
        br.close();
    }
}