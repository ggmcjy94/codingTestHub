import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            dp[i][0] = Integer.parseInt(st.nextToken());
            dp[i][1] = Integer.parseInt(st.nextToken());
            dp[i][2] = Integer.parseInt(st.nextToken());
        }

        // 1부터 N-1까지 각 i별 i-1의 서로 다른 색상 중 최솟값을 누적하여 더한다.
        for (int i = 1; i < N; i++) {
            dp[i][0] += Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] += Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] += Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        bw.write(Math.min(Math.min(dp[N-1][0] , dp[N-1][1]), dp[N-1][2]) + "");

        //1번 집의 색은 2번 집의 색과 같지 않아야 한다.
        //N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
        //i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.
//        3
//26 40 83 26
//49 60 57 49
//13 89 99 13
//96


        bw.flush();
        bw.close();
    }

}