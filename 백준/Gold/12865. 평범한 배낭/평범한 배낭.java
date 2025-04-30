import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[] W = new int[N + 1];
        int[] V = new int[N + 1];
        for (int i =1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            W[i] = n;
            V[i] = k;
        }

        int[] dp = new int[K+1];
        for (int i= 1; i <= N; i++) {
            for (int j = K; j >= W[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - W[i]] + V[i]);
            }
        }

        bw.write(dp[K] +"");
        bw.flush();
        bw.close();
        br.close();

    }
}