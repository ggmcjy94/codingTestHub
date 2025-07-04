import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[][] arr;
    static boolean[][][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static class Node {
        int x, y, dist, breakCnt;

        Node(int x, int y, int dist, int breakCnt) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.breakCnt = breakCnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M][K + 1];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(0, 0, 1, 0));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            if (curr.x == N - 1 && curr.y == M - 1) {
                return curr.dist;
            }

            for (int d = 0; d < 4; d++) {
                int nx = curr.x + dx[d];
                int ny = curr.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                // 빈칸
                if (arr[nx][ny] == 0 && !visited[nx][ny][curr.breakCnt]) {
                    visited[nx][ny][curr.breakCnt] = true;
                    queue.offer(new Node(nx, ny, curr.dist + 1, curr.breakCnt));
                }

                // 벽
                if (arr[nx][ny] == 1 && curr.breakCnt < K && !visited[nx][ny][curr.breakCnt + 1]) {
                    visited[nx][ny][curr.breakCnt + 1] = true;
                    queue.offer(new Node(nx, ny, curr.dist + 1, curr.breakCnt + 1));
                }
            }
        }

        return -1;
    }
}