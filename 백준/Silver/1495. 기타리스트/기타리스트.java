import java.io.*;
import java.util.*;

public class Main {
    static int T,N,S,E,M,R,K,min,max;
    static long ans;
    static int[] arr;
    static int dx[] = {0, 0, -1, -1, -1, 1, 1, 1};
    static int dy[] = {1, -1, -1, 0, 1, -1, 0, 1};
    static Queue<int[]> queue = new LinkedList<>();
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        int[] vol = new int[M+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i<=M; i++) {
            vol[i] = -1;
        }
        vol[S] = 0;

        for (int i = 1; i <= N; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= M; j++) {
                if (vol[j] == i - 1) {
                    int minus = j-arr[i-1];
                    int plus = j+arr[i-1];

                    if(minus>=0){
                        list.add(minus);
                    }
                    if(plus<=M){
                        list.add(plus);
                    }
                }
            }
            for (int i1 : list) vol[i1]= i;
        }
        int res = -1;
        for (int i =0; i<= M; i++) if (vol[i]==N) res = Math.max(res, i);

        bw.write(res+"");

        bw.flush();
        bw.close();
        br.close();
    }
}
