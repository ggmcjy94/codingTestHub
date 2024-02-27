import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N;
    static int[][] adj = new int[25][25];
    static boolean[][] visited = new boolean[25][25];
    static int[] aparts = new int[25 * 25];
    static int apartNum;
    static int[] dx = {0 , 0 , 1 , -1};
    static int[] dy = {1, -1, 0 , 0};

    static void bfs(int x , int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y] = true;
        aparts[apartNum]++;
        while (!queue.isEmpty()) {
            int nowx = queue.peek()[0];
            int nowy = queue.peek()[1];
            queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextx = nowx + dx[i];
                int nexty = nowy + dy[i];
                if (nextx < 0 || nexty < 0 || nextx >= N || nexty >= N) continue;
                if (adj[nextx][nexty] == 0 || visited[nextx][nexty]) continue;
                queue.add(new int[]{nextx, nexty});
                visited[nextx][nexty] = true;
                aparts[apartNum]++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int i =0; i<N; i++) {
            String str = sc.next();
            for (int j = 0; j < N; j++) {
                adj[i][j] = str.charAt(j) -'0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (adj[i][j] == 1 && !visited[i][j]) {
                    apartNum++;
                    bfs(i, j);
                }
            }
        }

        Arrays.sort(aparts);
        System.out.println(apartNum);
        for (int i =0 ; i< aparts.length; i++) {
            if (!(aparts[i] == 0)) System.out.println(aparts[i]);
        }


    }
}
