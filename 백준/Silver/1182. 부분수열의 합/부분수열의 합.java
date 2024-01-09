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
    static void rec_fuc(int k, int value) {
        if (k == N+1) {
            if (value == M) ans++;
        } else {
            
            rec_fuc(k+1, value+nums[k]);
            rec_fuc(k+1, value);
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N+1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) nums[i] = Integer.parseInt(st.nextToken());

        rec_fuc(1,0);
        if (M == 0){
            ans--;
        }
        bw.write(ans+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
