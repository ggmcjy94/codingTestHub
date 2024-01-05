import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


    static int N,M;
    static int[][] arr;
    static int[] selected,used;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static Queue<int[]> queue = new LinkedList<>();
    static boolean[][] visited;

    static StringBuilder sb;

    static void bfs() {



    }
    //4 2
    static void rec_fuc(int k) {
        if (k == M+1) {
            for (int i = 1; i<=M; i++) sb.append(selected[i]).append(' ');
            sb.append('\n');
        } else {

            for (int c = 1; c <= N; c++) {
                if (used[c] == 1) continue;
                selected[k] = c;
                used[c] = 1;
                rec_fuc(k+1);
                selected[k] = 0;
                used[c] = 0;


            }


        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M+1];
        used = new int[N+1];
        rec_fuc(1);
        bw.write(sb.toString());


        bw.flush();
        bw.close();
        br.close();
    }
}
