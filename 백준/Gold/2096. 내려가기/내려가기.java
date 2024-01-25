import java.io.*;
import java.util.*;

public class Main {
    static int T,N,M,R,K,min,max;
    static long ans;
    static int[] arr;
    static int dx[] = {0, 0, -1, -1, -1, 1, 1, 1};
    static int dy[] = {1, -1, -1, 0, 1, -1, 0, 1};
    static Queue<int[]> queue = new LinkedList<>();
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        //3
        //1 2 3
        //4 5 6
        //4 9 0
        // dp[1][0] = arr[0]
        // dp[1][1] = arr[1]
        // dp[1][2] = arr[2]
        // dp[2][0][0] = Math.min(dp[i-1][0][0] , dp[i-1][1][0]) + arr[0]
        int[][][] dp = new int[100001][3][2];
        int[] arr = new int[3];
        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) arr[j] = Integer.parseInt(st.nextToken());
            if (i == 1) {
                dp[i][0][0] = dp[i][0][1] = arr[0];
                dp[i][1][0] = dp[i][1][1] = arr[1];
                dp[i][2][0] = dp[i][2][1] = arr[2];
            } else {
                dp[i][0][0] = Math.min(dp[i-1][0][0], dp[i-1][1][0]) + arr[0];
                dp[i][0][1] = Math.max(dp[i-1][0][1], dp[i-1][1][1]) + arr[0];
//                System.out.print(dp[i][0][0]+" "+dp[i][0][1]);
//                System.out.println();
                dp[i][1][0] = Math.min(dp[i-1][0][0], Math.min(dp[i-1][1][0], dp[i-1][2][0])) + arr[1];
                dp[i][1][1] = Math.max(dp[i-1][0][1], Math.max(dp[i-1][1][1], dp[i-1][2][1])) + arr[1];
//                System.out.print(dp[i][1][0]+" "+dp[i][1][1]);
//                System.out.println();
                dp[i][2][0] = Math.min(dp[i-1][1][0], dp[i-1][2][0]) + arr[2];
                dp[i][2][1] = Math.max(dp[i-1][1][1], dp[i-1][2][1]) + arr[2];
//                System.out.print(dp[i][2][0]+" "+dp[i][2][1]);
//                System.out.println();
            }
        }

        int min = Math.min(dp[T][0][0],Math.min(dp[T][1][0],dp[T][2][0]));
        int max = Math.max(dp[T][0][1],Math.max(dp[T][1][1],dp[T][2][1]));

        bw.write(max + " "+ min);


        bw.flush();
        bw.close();
        br.close();
    }
}
