import java.io.*;
import java.util.*;

public class Main {
    static int T,N,S,E,M,R,Q,K,min,max;
    static long ans;
    static int[] arr,nums,operator,order;
    static int[] selected,used;
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
        N = Integer.parseInt(br.readLine());
        long[] longs = new long[N+1];
        for (int i = 1; i <= N; i++) {
            longs[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(longs, 1, N+1);
        long mode = longs[1];
        int modeCnt = 1, curCnt = 1;
        // 1 1 1 2 2
        for (int i = 2; i <= N; i++) {
            if (longs[i] == longs[i-1]) {
                curCnt++;
            } else {
                curCnt = 1;
            }

            if (modeCnt < curCnt) {
                modeCnt = curCnt;
                mode = longs[i];
            }
        }

        bw.write(mode+"");

        bw.flush();
        bw.close();
        br.close();
    }
}
