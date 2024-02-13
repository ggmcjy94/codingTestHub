import java.io.*;
import java.util.*;

public class Main {
    static int T,N,S,E,M,R,Q,K,min,max;
    static long ans;
    static int[] arr;
    static int[] selected;
    static int[] dp;
    static int dx[] = {0, -1, 0 ,1};
    static int dy[] = {1, 0, -1, 0};
    static Queue<int[]> queue = new LinkedList<>();
    static ArrayList<Integer>[] con;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    static void def_rec(int k) {
        if (k ==  M+1) {
            for (int i = 1; i<=M; i++)sb.append(selected[i]).append(' ');
            sb.append("\n");
        } else {
            for (int c = 1; c<=N;c++) {
                selected[k] = c;
                def_rec(k+1);
                selected[k] = 0;
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
        selected = new int[M + 1];
        def_rec(1);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
