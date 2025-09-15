import java.io.*;
import java.util.*;

public class Main {
    static int cnt;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        rec(n);
        int[] dp = new int[n];
        int cnt2 =0;
        dp[0]= 0;
        dp[1] =1;
        for (int i = 2; i < n; i++) {
            cnt2++;
            dp[i] = dp[i-1] + dp[i-2];
        }
        bw.write(cnt + " " + cnt2);
        bw.flush();
        bw.close();
        br.close();
    }

    static int rec (int x) {
        if (x==1 || x == 2) {
            cnt++;
            return 1;
        } else {
            return rec(x - 2) + rec(x - 1);
        }
    }
}