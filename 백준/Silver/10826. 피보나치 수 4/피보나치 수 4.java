import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        BigInteger[] dp = new BigInteger[10001];
        dp[0]= new BigInteger("0");
        dp[1]= new BigInteger("1");
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i-1].add(dp[i-2]);
        }
        bw.write(dp[N]+"");
        bw.flush();
        bw.close();
        br.close();
    }

}