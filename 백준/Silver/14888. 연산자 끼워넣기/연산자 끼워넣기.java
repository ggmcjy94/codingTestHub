import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br;
    static BufferedWriter bw;

    static List<List<Integer>> graph = new ArrayList<>();
    static int[][] arr;
    static boolean[] visit;
    static boolean[][] visited;
    static int[] checked;
    static int N , K, s,x,y;
    static int cnt = 1;
    static boolean chek;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[] number;
    static int[] operator = new int[4];
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        number = new int[N];
        for (int i = 0; i<N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i<4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(number[0], 1);
        bw.write(MAX+"\n");
        bw.write(MIN+"\n");

        bw.flush();
        bw.close();
    }

    private static void dfs(int num, int id) {
        if (id == N) {
            MAX = Math.max(MAX, num);
            MIN = Math.min(MIN, num);
            return;
        }

        for (int i = 0; i< 4 ; i++) {
            if (operator[i] > 0) {
                operator[i]--;
//3
//3 4 5
//1 0 1 0
                switch (i) {
                    case 0: dfs(num + number[id], id + 1); break;
                    case 1: dfs(num - number[id], id + 1); break;
                    case 2: dfs(num * number[id], id + 1); break;
                    case 3: dfs(num / number[id], id + 1); break;
                }
                operator[i]++;
            }
        }
    }
}
