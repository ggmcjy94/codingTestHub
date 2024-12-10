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
    static boolean[] visit;


    //) M = 1
    //
    //모든 경우의 수를 출력합니다.
    //(2) M = 2
    //
    //중복된 경우를 배제하고 출력합니다. 1, 1, 2와 1, 2, 1 그리고 2, 1, 1은 중복입니다.
    //(3) M = 3
    //
    //중복된 눈이 나오지 않는 경우만 출력합니다.

    //2 1
    // 1 1
    // 1 2
    static void back(int st, int num) {
        if (num == N) {
            int sum = 0;
            for (int i = 1; i <= num; i++) {
                sum += arr[i];
            }
            if (sum == M) {
                for (int i = 1; i <= num; i++) {
                    System.out.print(arr[i]+" ");
                }
                System.out.println();
            }
            return;
        } else {
            for (int i = 1; i <= 6; i++) {
                arr[st] = i;
                back(st + 1, num + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[7];
        arr[0] = 1;
        back(1,0);
        bw.flush();
        bw.close();
        br.close();

    }

}