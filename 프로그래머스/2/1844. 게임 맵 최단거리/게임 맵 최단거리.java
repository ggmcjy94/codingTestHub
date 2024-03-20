import java.util.*;
class Solution {
    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nox = poll[0];
            int noy = poll[1];
            for (int i = 0; i < 4; i++) {
                int nex = nox + dx[i];
                int ney = noy + dy[i];
                if (nex < 0 || ney < 0 || nex >= N || ney >= M) continue;
                if (visited[nex][ney]) continue;
                if (arr[nex][ney] == 1) {
                    arr[nex][ney] = arr[nox][noy]+1;
                    visited[nex][ney] = true;
                    queue.add(new int[]{nex,ney});
                }
            }
        }

    }
    public int solution(int[][] maps) {
        int answer = 0;
        arr = maps;
        N = maps.length;
        M = maps[0].length;
        visited = new boolean[N][M];
        bfs(0,0);
        answer = arr[N-1][M-1];
        if (answer == 1) {
            answer = -1;
        }
        return answer;
    }
}