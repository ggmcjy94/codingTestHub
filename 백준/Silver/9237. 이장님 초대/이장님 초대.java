import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br;
    static BufferedWriter bw;
    static int N,M;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {1, 0 , -1, 0};
    static int[] dy = {0, 1 , 0, -1};
    static int max,count = 0;

    static void bfs(int x , int y) {

    }
    static class Classes {
        int s,e;

        public Classes( int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1

        // 6 6 7 7
        // 3 3 2 3


        //39 38 9 35 39 20
        //39
        //39 39
        //41 42 42 40 26 16
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, Collections.reverseOrder());
        int max = Integer.MIN_VALUE;
        int cnt = 1;
        for (Integer integer : arr) {
            cnt++;
            max = Math.max(integer+cnt, max);
        }
        bw.write(max+"");
        bw.flush();
        bw.close();
    }
}
