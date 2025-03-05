import java.io.*;
import java.util.*;

public class Main {

    static int N,M;
    static long[][] dp;
    //탁자 위에 돌 N개가 있다. 상근이와 창영이는 턴을 번갈아가면서 돌을 가져가며, 돌은 1개, 3개 또는 4개 가져갈 수 있다. 마지막 돌을 가져가는 사람이 게임을 지게 된다.
    //
    //두 사람이 완벽하게 게임을 했을 때, 이기는 사람을 구하는 프로그램을 작성하시오. 게임은 상근이가 먼저 시작한다.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int [] dp = new int[1001];
        // 1 3,4
        dp[1] = 1; // 창영
        dp[2] = 0; // 상근
        dp[3] = 1; // 창영

        for (int i = 4; i <= N; i++) {
            if (dp[i-1] + dp[i - 3] + dp[i-4] > 0) {
                dp[i] = 0;
            } else {
                dp[i] = 1;
            }
        }


        if (dp[N]  == 0 ) {
            bw.write("SK");
        } else {
            bw.write("CY");
        }
        bw.flush();
        bw.close();
        br.close();
    }


}