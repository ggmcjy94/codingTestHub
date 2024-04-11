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
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        ans = new Integer[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ans[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(ans);

        // 1 2 100 101
        // 2

        //1 2 3 4
        //3
        //4
        int cnt = 1;
        int a = L + ans[0];
        for (int i = 1; i < N; i++) {
            if (ans[i] >= a) {
                a = L + ans[i];
                cnt++;
            }
        }

        bw.write(cnt+"");
        bw.flush();
        br.close();
        bw.close();
    }
}