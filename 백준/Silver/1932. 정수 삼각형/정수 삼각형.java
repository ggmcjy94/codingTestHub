import java.io.*;
import java.util.StringTokenizer;

public class Main {
    //5
    //7
    //3 8
    //8 1 0
    //2 7 4 4
    //4 5 2 6 5

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] arr = new int[n+1][n+1];
        int[][] dp = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= i; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + arr[i][j];
            }
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            result = Math.max(dp[n][i], result);
        }
        bw.write(result + " ");
        bw.flush();
        bw.close();
    }

}