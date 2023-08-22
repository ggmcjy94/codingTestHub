import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));


        int[] dp = new int[11];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i < 11; i++) {
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
        }

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++){
            int T = Integer.parseInt(br.readLine());
            bw.write(dp[T] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
