import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br;
    static BufferedWriter bw;

    static List<List<Integer>> graph = new ArrayList<>();
    static int[][] arr;
    static boolean[] visit;
    static int[] checked;
    static int N , M, R,  cnt;

    static void dfs(int r)  {
        checked[r] = cnt;

        for (int i = 0; i < graph.get(r).size(); i ++) {
            Integer newNode = graph.get(r).get(i);
            if (checked[newNode] == 0) {
                cnt++;
                dfs(newNode);
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

        checked = new int[N + 1];
        for (int i = 0 ; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph.get(s).add(e);
            graph.get(e).add(s);
        }

        for (int i = 1; i <=N; i++) {
            Collections.sort(graph.get(i));
        }

        cnt = 1;
        dfs(R);
        for (int i = 1; i < checked.length; i++) {
           bw.write(checked[i] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
