import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int N;
    static int[][] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        tree = new int[N+1][2];
        for (int i = 0; i< N; i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            tree[id][0] = left;
            tree[id][1] = right;
        }

        int result = 2 * (N-1);
        int now = 1;
        while (true) {
            if (tree[now][1] == -1) break;
            now = tree[now][1];
            result--;
        }

        bw.write(result+"");

        bw.flush();
        bw.close();
        br.close();
    }

}
