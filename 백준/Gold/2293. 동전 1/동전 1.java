import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] dp = new int[K+1];
        int[] arr = new int[N+1];
        dp[0] = 1;
        for (int i = 1; i<=N; i++) {
            arr[i] = Integer.parseInt(br.readLine()); //1 2 5 
            for (int j = arr[i]; j <= K; j++) { // 1 10
                dp[j] += dp[j - arr[i]]; 
            }
        }
        bw.write(dp[K]+ "");
        bw.flush();
        bw.close();
    }
}