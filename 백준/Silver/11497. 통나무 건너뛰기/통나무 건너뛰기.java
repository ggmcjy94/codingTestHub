import java.io.*;
import java.util.*;

public class Main {

    static int N,M,C,R,T,A,B;
    static int ans;
    static StringTokenizer st;
    static int[] dx = {1,0,-1,0,1,-1,-1,1};
    static int[] dy = {0,1,0,-1,1,1,-1,-1};
    static int[] arr, brr;
    static ArrayList<Integer>[] graph;
    static char[][] map;
    static Queue<int[]> iceQueue;
    static boolean[][] visited;
    static boolean[] visit;
    static int[] dist;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            brr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            int l = 0;
            int r = N - 1;
            for (int i = 0; i < N; i++) {
                if (i % 2 == 0) {
                    brr[l] = arr[i];
                    l+=1;
                } else {
                    brr[r] = arr[i];
                    r -= 1;
                }
            }
            int min = Math.abs(brr[0] - brr[1]);
            for (int i = 1; i < N-1; i++) {
                min = Math.max(min, Math.abs(brr[i]-brr[i+1]));
            }
            bw.write(min +"\n");
        }
        // 2 4 5 7 9 = 7
        // 2       4
        // 2 5   7 4
        // 2 5 9 7 4


        // 2 5 9 7 4

        // 2 5 9 7 4

        // 9 2 7
        // 9 4 5
        // 9 5 4
        // 9 7 2

        bw.flush();
        bw.close();
        br.close();

    }

}

