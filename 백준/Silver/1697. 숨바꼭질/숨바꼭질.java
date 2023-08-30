import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static int[] arr;
    static int n,m;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        if (n >= m) {
            bw.write(n - m +"");
        } else {
            int result = bfs();
            bw.write(result +"");
        }
        bw.flush();
        bw.close();
    }
    private static int bfs() {
        arr = new int[100001];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        arr[n] = 1;
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            for (int i = 0; i<3; i++) {
                int nx;
                if (i == 0) {
                    nx = temp - 1;
                } else if (i == 1) {
                    nx = temp + 1;
                } else {
                    nx = temp * 2;
                }
                if (nx == m) {
                    return arr[temp];
                }
                if (nx >= 0 && nx < 100001  && arr[nx] == 0) {
                    arr[nx] = arr[temp] + 1;
                    queue.add(nx);
                }
            }
        }
        return 0;
    }
}