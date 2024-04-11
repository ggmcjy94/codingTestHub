import java.io.*;
import java.util.*;

public class Main {
    static int N, M, L,res;
    static Integer[] vol,tel,ans;
    static int[][] dp, arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        ans = new Integer[N];
        for (int i = 0; i  < N; i++) ans[i] = Integer.parseInt(br.readLine());
        Arrays.sort(ans);
        int max = Integer.MIN_VALUE;
        //3 10 15 25
        //12 30 30 25
        for (int i = 0; i <N; i++) {
            max = Math.max(max, ans[i] * (N - i));
        }
        bw.write(max+"");
        bw.flush();
        br.close();
        bw.close();
    }
}