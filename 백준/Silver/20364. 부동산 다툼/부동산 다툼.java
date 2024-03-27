import java.io.*;
import java.util.*;

public class Main {

    static int N,Q,M,C,R,T,A,B;
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
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        HashSet<Integer> owned = new HashSet<>();
        for (int i = 1; i <= Q; i++) {
            int now = Integer.parseInt(br.readLine());
            int num = 0;
            for (int j = now; j >= 2; j/=2) {
                if (owned.contains(j)) {
                    num = j;
                }
            }
            bw.write(num+"\n");
            if (num==0) {
                owned.add(now);
            }

        }


        bw.flush();
        bw.close();
        br.close();

    }

}

