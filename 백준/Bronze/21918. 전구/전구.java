import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int T,N,C,V,S,E,M,Q,K,R,min,max;
    static long ans;
    static int[][] dis;
    static char[][] map;
    static int[] arr,nums,operator,order,dist;
    static int[] selected,used;
    static int[] dp,A;
    static int dx[] = {0, -1, 0 ,1};
    static int dy[] = {1, 0, -1, 0};
    static ArrayList<Integer>[] graph;
    static boolean[][] visited,possible;
    static boolean[][][] visit;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i<=N; i++) arr[i] = Integer.parseInt(st.nextToken());


        for (int i = 0; i<M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 1) {
                arr[b] = c;
            }
            // 0 1 0 1 0 0 0 0

            if (a == 2) {
                for (int l = b; l <= c; l++) {
                    if (arr[l]== 1) arr[l] = 0;
                    else arr[l] = 1;
                }
            }
            if (a == 3) {
                for (int l = b; l <= c; l++) arr[l] = 0;
            }
            if (a == 4) {
                for (int l = b; l <= c; l++) arr[l] =1;
            }
        }

        for (int i=1; i <= N; i++) bw.write(arr[i] +" ");
        bw.flush();
        bw.close();
        br.close();
    }

}
