import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br;
    static BufferedWriter bw;
    static int[][] arr;
    static boolean[][] visited;
    static int[][] result;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int N,M,K,X,r,g,b,res;
    static int max = Integer.MIN_VALUE;
    static int min_count = 0;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static List<Integer> arr2 = new ArrayList<>();
    static int maxHeight=0;
    static void bfs(int x, int y, int k) {
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nox = poll[0];
            int noy = poll[1];
            for (int i = 0; i < 4; i++) {
                int nex = nox + dx[i];
                int ney = noy + dy[i];
                if (nex < 0 || nex >= N || ney < 0 || ney >= N) continue;
                if (arr[nex][ney] > k && !visited[nex][ney]) {
                    queue.add(new int[] {nex, ney});
                    visited[nex][ney] = true;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] > maxHeight) {
                    maxHeight =arr[i][j];
                }
            }
        }

        for (int k = 0; k <= maxHeight; k++) {
            visited = new boolean[N][N];
            int res = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j<N; j++) {
                    if (arr[i][j] > k && !visited[i][j]) {
                        res++;
                        bfs(i , j, k);
                    }
                }
            }
            max = Math.max(max, res);
        }
        bw.write(max+"");

        //5
        //6 8 2 6 2
        //3 2 3 4 6
        //6 7 3 3 2
        //7 2 5 3 6
        //8 9 5 2 7
        //5
        bw.flush();
        bw.close();
    }
//    static class Node {
//        int x, y;
//
//        public Node(int x, int y) {
//            this.x = x;
//            this.y = y;
//        }
//    }
}
