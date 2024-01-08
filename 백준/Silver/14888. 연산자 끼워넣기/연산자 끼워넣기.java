import java.io.*;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


    static int N,M,min,max;
    static int[][] arr;
    static int[] nums , operator,order;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static Queue<int[]> queue = new LinkedList<>();
    static boolean[][] visited;



    static StringBuilder sb = new StringBuilder();

    static void bfs() {



    }

    static int calculator() {
        int value = nums[1];;
        for (int i = 1; i<=N-1; i++) {
            if (order[i] == 1) value = value+nums[i+1];
            if (order[i] == 2) value = value-nums[i+1];
            if (order[i] == 3) value = value*nums[i+1];
            if (order[i] == 4) value = value/nums[i+1];
        }
        return value;
    }
    static void rec_fuc(int k) {
        if (k == N) {
            int value = calculator();
            max = Math.max(max, value);
            min = Math.min(min, value);
        } else {

            for (int c = 1; c <= 4; c++) {
                if (operator[c] >= 1) {
                    operator[c]--;
                    order[k] = c;
                    rec_fuc(k+1);
                    operator[c]++;
                    order[k] = 0;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nums = new int[N+1];
        operator = new int[5];
        order = new int[N+1];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i<=N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine()," ");
        for (int i = 1; i<=4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        rec_fuc(1);

        sb.append(max).append('\n').append(min);
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
