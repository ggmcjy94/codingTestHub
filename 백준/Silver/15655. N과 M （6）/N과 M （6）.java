import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[] selected, arr;
    static boolean[] used;
    static StringBuilder sb = new StringBuilder();
// 1 7 8 9
    static void def_rec(int k, int[]selected, int si) {
        if (k == M+1) {
            for (int i = 1; i <= M ; i++) sb.append(selected[i] + " ");
            sb.append("\n");
        } else {
            for (int i = si; i <= N; i++) {
                selected[k] = arr[i]; // 1 7
                def_rec(k+1, selected, i+1);
            }
        }
    }
    // 1 7
    // 1 8
    // 1 9
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        def_rec(1 , new int[M+1], 1);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
