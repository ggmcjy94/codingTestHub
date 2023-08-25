import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] cups = new int[n+1];
        int[] dp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            cups[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = cups[1];
        if (n > 1) dp[2] = cups[1] + cups[2];


        for (int i = 3; i<=n; i++) {
            dp[i] =Math.max(dp[i - 1], Math.max(dp[i - 3] + cups[i - 1] + cups[i], dp[i - 2] + cups[i]));
            //  28
        }
        bw.write(dp[n] + "");
// dp[1] = 6
// dp[2] = 16
        //dp[3] = 23
        // math.max (23, 25, 28)
        //Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]));
        // dp[3] = Math.max(dp[i-1],Math.max(dp[i-2]+arr[i], dp[i - 3] + arr[i-1] + arr[i])); 16,23
//        6, 10, 13, 9, 8, 1
        // 6 10 9 8
        // 10 13 8 1
        // 13 9 1
        // 9 8

        //1 = math.max(6 , 10)
        //2 = dp[1] + math.max()

        bw.flush();
        bw.close();
    }

}