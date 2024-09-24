import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[] selected, arr;
    static boolean[] used;
    static StringBuilder sb = new StringBuilder();

    static void def_rec(int k) {
        if (k == M + 1) {
            for (int i = 1; i <= M; i++) sb.append(selected[i] +" ");
            sb.append("\n");
        } else {
            for (int c = 1; c <= N; c++) {
                if (used[c]) continue;
                used[c] = true;
                selected[k] = arr[c];
                def_rec(k+1);
                used[c] = false;
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        selected = new int[N+1];
        used = new boolean[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1 ; i <= N; i ++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        def_rec(1);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
