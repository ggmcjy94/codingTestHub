import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {

    static int N , M, S;
    static int [][] map;
    static int[] arr;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static boolean[][] visited;
    static int res;
    //5
    //522
    //6
    //84
    //7311
    //19

    //3


    static void back(int count, int depth, int sum) {
        res = Math.max(res, count);

        if (depth == N) return;

        for (int i = depth; i < N; i++) {
            if (isNotCarry(sum , arr[i])) {
                back(count+1, i + 1, sum + arr[i]);
            }
        }
    }

    private static boolean isNotCarry(int sum, int val) {

        while (sum > 0 || val > 0) {
            int num1 = sum % 10;
            int num2 = val % 10;

            if (num1+num2 >= 10) {
                return false;
            }

            sum /= 10;
            val /= 10;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(br.readLine());
            arr[i] = val;
        }

        back(0, 0 , 0);
        bw.write(res+"");
        bw.flush();
        bw.close();
        br.close();

    }

}