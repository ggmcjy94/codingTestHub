import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


    static int N,M,min,max, ans;
    static int[][] arr;
    static int[] nums , operator,order, col;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static Queue<int[]> queue = new LinkedList<>();
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();


    static boolean attackable(int r1, int c1, int r2, int c2) {
        if (c1 == c2) return true;
        if (r1 - c1 == r2 - c2) return true;
        return r1 + c1 == r2 + c2;
    }

    static boolean validity_check() {
        for (int i = 1; i<=N; i++) {
            // (i,col[i])
            for (int j = 1; j <i; j++) {
                if (attackable(i, col[i],j , col[j])) {
                    return false;
                }
            }
        }
        return  true;
    }
    static void rec_fuc(int row) {
        if (row == N) {

        } else {
            for (int i = 0; i < N; i++) {

                rec_fuc(row+1);

            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i =0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());


        int s=0, e=0, sum=0, cnt=0;

        while (true) {
            if (sum >= M) {
                sum -= nums[s++];
            } else if (e == N) break;
            else {
                sum += nums[e++];
            }
            if (sum == M) cnt++;
        }
        bw.write(cnt+"");


        bw.flush();
        bw.close();
        br.close();
    }
}
