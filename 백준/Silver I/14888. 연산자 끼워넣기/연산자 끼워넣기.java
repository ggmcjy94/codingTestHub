import java.io.*;
import java.util.*;

public class Main {
    static int T,N,S,E,M,R,Q,K,min,max;
    static long ans;
    static int[] arr,nums,operator,order;
    static int[] selected,used;
    static int[] dp;
    static int dx[] = {0, -1, 0 ,1};
    static int dy[] = {1, 0, -1, 0};
    static Queue<int[]> queue = new LinkedList<>();
    static ArrayList<Integer>[] con;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    static int calculator(int operand1, int operator, int operand2) {
        if (operator == 1) {
            return operand1 + operand2;
        }
        else if (operator == 2) {
            return operand1 - operand2;
        }
        else if (operator == 3) {
           return operand1 * operand2;
        }
        else {
          return operand1 / operand2;
        }
    }
    static void def_rec(int k, int value) {
        if (k == N) {
            max = Math.max(max,value);
            min = Math.min(min,value);
        } else {

            for (int c = 1; c<=4; c++) {
                if (operator[c] >= 1) {
                    operator[c]--;
                    order[k] = c;
                    int new_value = calculator(value, c, nums[k+1]);
                    def_rec(k+1, new_value);
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
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        nums = new int[N+1];
        order = new int[N+1];
        operator = new int[5];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i<=N; i++) nums[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= 4; i++) operator[i] = Integer.parseInt(st.nextToken());

        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;

        def_rec(1,nums[1]);

        StringBuilder append = sb.append(max).append(" ").append(min);

        bw.write(append.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
