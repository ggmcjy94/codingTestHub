
import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br;
    static BufferedWriter bw;

    static List<List<Integer>> graph = new ArrayList<>();
    static int[][] arr;
    static boolean[] visit;
    static boolean[][][] visited;
    static int[] checked;
    static int N , M,R, s,x,y;
    static int cnt = 1;
    static boolean chek;
    static int [][] d = {{0,1}, {1,0}, {1,1}, {-1,1}};;
    static int[] number;
    static int[] operator = new int[4];
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;

    private static void dfs(int start) {
        number[start] = cnt;
        for (int i =0; i< graph.get(start).size(); i++) {
            Integer newStart = graph.get(start).get(i);
            if (number[newStart] == 0) {
                cnt++;
                dfs(newStart);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        number = new int[N+1];
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph.get(s).add(e);
            graph.get(e).add(s);
        }

        for (int i = 1; i < graph.size(); i++) {
            Collections.sort(graph.get(i),Collections.reverseOrder());
        }

        cnt = 1;

        dfs(R);

        for (int i = 1; i < number.length; i++) {
            bw.write(number[i] + "\n");
        }
        bw.flush();
        bw.close();
    }


}
