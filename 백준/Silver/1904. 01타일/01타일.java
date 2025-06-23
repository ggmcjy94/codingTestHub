import java.io.*;

public class Main {
    static int N;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        int[] dp = new int[1000001];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2; //    00          11 
        for (int i = 3; i <= 1000000; i++) {
            dp[i] = (dp[i-1]+ dp[i-2])%15746;
        }
        bw.write(dp[N]+"");
        bw.flush();
        bw.close();
        br.close();

// 그러므로 지원이는 타일로 더 이상 크기가 N인 모든 2진 수열을 만들 수 없게 되었다. 예를 들어, N=1일 때 1만 만들 수 있고, N=2일 때는 00, 11을 만들 수 있다. (01, 10은 만들 수 없게 되었다.) 
// 또한 N=4일 때는 0011, 0000, 1001, 1100, 1111 등 총 5개의 2진 수열을 만들 수 있다.

    }

}