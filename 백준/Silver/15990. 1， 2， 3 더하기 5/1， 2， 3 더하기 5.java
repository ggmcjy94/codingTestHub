import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[100001][4];
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int i = 4; i<=100000; i++) {
            dp[i][1]= (dp[i-1][2] + dp[i-1][3]) % 1000000009 ;
            dp[i][2]= (dp[i-2][1] + dp[i-2][3]) % 1000000009 ;
            dp[i][3]= (dp[i-3][1] + dp[i-3][2]) % 1000000009 ;
        }
        // 1+3+1
        // 2+3
        // 2+1+2
        // 3+2

        //3
        //4
        //7
        //10

        //3
        //9
        //27
        for (int i = 0; i<N; i++) {
            int T = Integer.parseInt(br.readLine());
            bw.write((dp[T][1]+dp[T][2]+dp[T][3]) %1000000009 +"\n");
        }
        bw.flush();
        bw.close();
    }
}
