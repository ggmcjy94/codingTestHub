import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        /

        // A만 표시되어져 있었다. 버튼을 누르니 글자가 B로 변했다.
        // 한 번 더 누르니 BA로 바뀌고, 그 다음에는 BAB,
        // 그리고 BABBA로 바뀌었다. 상근이는 화면의 모든 B는 BA로 바뀌고,
        // A는 B로 바뀐다는 사실을 알게되었다.
        // 4
        // 2 3
        // dp[0] = 'A' 1 0
        // dp[1] = 'B' 0 1
        // dp[2] = 'BA' 1 1
        // dp[3] = 'BAB' 1 2
        // dp[4] = 'BABBA' 2 3
        //9625
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N+1][2];
        dp[0][0] = 1; // A 1 0
        dp[0][1] = 0; // B 0 1
        dp[1][0] = 0; // BA 1 1
        dp[1][1] = 1; // BA 1 1
        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i-2][0] + dp[i-1][0];
            dp[i][1] = dp[i-2][1] + dp[i-1][1];
        }
        bw.write(dp[N][0]+ " " + dp[N][1]);
        bw.flush();
        bw.close();
    }
}
