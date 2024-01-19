import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N,M,min,max, ans;
    static int[][] arr;
    static int[] nums , operator,order, col;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static Queue<int[]> queue = new LinkedList<>();
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();

    static int get_odd_cnt(int x) {
        int res =0;
        while (x > 0) {
            int digit = x %10;
            if (digit % 2 == 1) res++;
            x /= 10;
        }
        return res;
    }

    static void dfs(int x , int total_odd_cnt){
        // 한자리일 경우
        if (x <= 9) {
            min = Math.min(min, total_odd_cnt);
            max = Math.max(max, total_odd_cnt);
            return;
        }
        // 두자리일 경우
        if (x <= 99) {
            int next_x = (x / 10) + (x % 10);
            dfs(next_x, total_odd_cnt + get_odd_cnt(next_x));
            return;
        }
        // 세자리이상 일 경우
        String s = Integer.toString(x);
        int length = s.length();
        for (int i = 0; i<= length - 3; i++) {
            for (int j = i + 1; j <= length-2; j++) {
                String x1 = s.substring(0, i + 1);
                String x2 = s.substring(i+1, j+1);
                String x3 = s.substring(j+1, length);
                int next_x = Integer.parseInt(x1)  + Integer.parseInt(x2) + Integer.parseInt(x3);
                dfs(next_x, total_odd_cnt + get_odd_cnt(next_x));
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        N = Integer.parseInt(br.readLine());
        dfs(N, get_odd_cnt(N));
        bw.write(min +" "+ max);
        bw.flush();
        bw.close();
        br.close();
    }

}
