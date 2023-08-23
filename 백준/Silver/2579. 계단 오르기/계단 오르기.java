import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int [] stairs = new int[n+1];
        for (int i = 1; i <=n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
//6
//10 dp1= 10
//20 dp2 = 30
//15 dp3 = 35
//25 dp4 = 55
//10 dp5 = 65
//20
        int[] dp = new int[n+1];
        dp[1] = stairs[1];
        for (int i = 2; i <= n; i++) {
            if (i == 2) {
                dp[2] = stairs[1] + stairs[2];
            } else if (i == 3) {
                dp[3] = Math.max(stairs[1], stairs[2]) + stairs[3];
            } else {
                dp[i] = Math.max(dp[i-3] + stairs[i-1], dp[i-2])+stairs[i];    
            }
        }
        bw.write(dp[n] + "");
        bw.flush();
        bw.close();
    }

}