import java.io.*;
import java.util.*;

public class Main {
    static int N,M,cnt;
    static int[][] arr;
    static ArrayList<ArrayList<Integer>> arr2;
    static int[] result;
    static boolean[] visited;
    static BufferedWriter bw;

    static void bfs (int k)  {
        Queue<Integer> queue = new LinkedList<>();
        visited[k] = true;
        queue.add(k);
        while (!queue.isEmpty()) {
            Integer temp = queue.poll();
            for (Integer ne : arr2.get(temp)) {
                if (!visited[ne]) {
                    visited[ne] = true;
                    result[ne] = temp;
                    queue.add(ne);
                }
            }
//            for (int i = 1; i <= N; i++) {
//                
//
//                if ((arr[temp][i] == 1||arr[i][temp] ==1) && !visited[i]) {
//                    result[i] = temp;
//                    queue.add(i);
//                    visited[i] = true;
//                }
//            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
//        arr = new int[N+1][N+1];
        arr2 = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            arr2.add(new ArrayList<>());
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
//            arr[s][e] = 1;
//            arr[e][s] = 1;
            arr2.get(s).add(e);
            arr2.get(e).add(s);
        }
        result = new int[N+1];
        visited = new boolean[N+1];
        bfs(1);

        for (int i = 2; i<=N; i++) {
            bw.write(result[i]+"\n");
        }
//7
 //1 6
//6 3
//3 5
//4 1
//2 4
//4 7

//4
//6
//1
//3
//1
//4


        bw.flush();
        bw.close();
    }
}