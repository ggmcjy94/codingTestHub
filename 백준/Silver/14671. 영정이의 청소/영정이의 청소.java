import java.io.*;
        import java.text.SimpleDateFormat;
        import java.util.*;
        import java.util.stream.Collectors;

public class Main {
    static int N,M,Q,T, K,R,C;
    static int[]dx={1,1,-1,-1};
    static int[]dy={-1,1,1,-1};
    static int[][] tree, dp;
    static int[] arr;
    static int[][] map, room;
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();
    static Queue<int[]> queue;


    // 1 1 0
    // 1 1 0
    // 1 1 0

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[2][2];


        for (int i = 0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            visited[x%2][y%2] = true;
        }

        // t f
        // t f

        if (visited[0][0] && visited[0][1] && visited[1][0] && visited[1][1]) {
            bw.write("YES");
        } else{
            bw.write("NO");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
