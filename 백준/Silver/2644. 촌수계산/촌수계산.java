import java.io.*;
import java.util.*;

public class Main {

    static int N,M, target1,target2;
    static int[][] arr;
    static int[] d;


    static void bfs(int x, int y) {
        Queue<Integer> queue= new LinkedList<>();
        queue.add(x);
        while (!queue.isEmpty()) {
            Integer v = queue.poll();
            if (v == y){
                break;
            }
            for (int i = 1; i <= N; i++) {
                if (arr[v][i] == 1 && d[i]==0) {
                    queue.add(i);
                    d[i] = d[v] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        target1 = Integer.parseInt(st.nextToken());
        target2 = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());
        arr = new int[N+1][N+1];
        // 1 2
        //9
        //7 3
        //7
        //1 2
        //1 3
        //2 7
        //2 8
        //2 9
        //4 5
        //4 6

        //3
        for (int i  = 0; i<M;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            arr[c][d] = 1;
            arr[d][c] = 1;
        }
        d = new int[N+1];
        bfs(target1, target2);
        if (d[target2] == 0) {
            bw.write("-1");
        } else {
            bw.write(d[target2]+ "");
        }
        bw.flush();
        bw.close();
    }
}