import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        //7
        //3 10
        //5 20
        //1 10
        //1 20
        //2 15
        //4 40
        //2 200
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[] t = new int[n];
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int T = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            t[i] = T;
            p[i] = P;
        }
        int[] dp = new int[n+1];
        for (int i=0; i<n; i++) {
            if (i + t[i] <= n) {
                dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
            }
            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }
        bw.write(dp[n] + "");
        bw.flush();
        bw.close();
    }
}
