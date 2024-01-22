import java.io.*;
import java.util.*;

public class Main {
    static int N,M,R,K,min,max, ans;
    static int[][] arr;
    static int[][] backUp;
    static String[] board;
    static Map<String, Integer> map = new HashMap<>();
    static int[] nums , operator, order, col;
    static int dx[] = {0, 0, -1, -1, -1, 1, 1, 1};
    static int dy[] = {1, -1, -1, 0, 1, -1, 0, 1};
    static Queue<int[]> queue = new LinkedList<>();
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();


    static void dfs(int i , int j, String path,int len){

        if (map.containsKey(path)) map.put(path, map.get(path) + 1);
        else map.put(path,1);

        if (len == 5) return;

        for (int dir =0; dir<8; dir++) {
            int ni = (i + dx[dir]) % N;
            int nj = (j + dy[dir]) % M;
            if (ni < 0) ni += N;
            if (nj < 0) nj += M;

            dfs(ni, nj, path + board[ni].charAt(nj) , len + 1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new String[N];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                dfs(i,j, Character.toString(board[i].charAt(j)), 1);
            }
        }

        while (K-- > 0) {
            String chk = br.readLine();
            bw.write(map.getOrDefault(chk, 0) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
