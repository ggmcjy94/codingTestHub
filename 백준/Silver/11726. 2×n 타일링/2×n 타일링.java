import java.io.*;
        import java.text.SimpleDateFormat;
        import java.util.*;
        import java.util.stream.Collectors;

public class Main {
    static int N,M,Q,T, K,R,C;
    static int[]dx={1,1,-1,-1};
    static int[]dy={-1,1,1,-1};
    static int[]  dp;
    static int[] arr;
    static int[][] map, room;
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();
    static Queue<int[]> queue;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];
        dp[1]= 1;
        dp[2]= 2;
        dp[3]= 3;
        for (int i = 4; i<=1000; i++) {
            dp[i] = (dp[i-2]+dp[i-1]) % 10007;
        }

        bw.write(dp[N]%10007+"");

        bw.flush();
        bw.close();
        br.close();
    }

}
