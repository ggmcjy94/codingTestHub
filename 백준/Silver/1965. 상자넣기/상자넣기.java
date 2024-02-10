import java.io.*;
import java.util.*;

public class Main {
    static int T,N,S,E,M,R,Q,K,min,max;
    static long ans;
    static int[] arr;
    static int[] dp;
    static int dx[] = {0, -1, 0 ,1};
    static int dy[] = {1, 0, -1, 0};
    static Queue<int[]> queue = new LinkedList<>();
    static ArrayList<Integer>[] con;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        dp= new int[N+1];
        arr = new int[N+1];


        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int data = Integer.parseInt(st.nextToken());
            arr[i] = data;
            dp[i]= 1;

            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            ans= Math.max(ans,dp[i]);
        }

        bw.write(ans+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
