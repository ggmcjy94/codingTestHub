import java.util.*;


class Solution {
    static int N, M,res;
    static char[][] arr;
    static boolean[][] visited;
    static int bfs(int x, int y){
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        res = arr[x][y] - '0';
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nox = poll[0];
            int noy = poll[1];
            for (int i = 0; i < 4; i++) {
                int nex = nox+dx[i];
                int ney = noy+dy[i];
                if (nex < 0|| ney <0 || nex>= N || ney >= M) continue;
                if (visited[nex][ney])continue;
                if (arr[nex][ney] == 'X') continue;
                queue.add(new int[]{nex,ney});
                visited[nex][ney] = true;
                res += arr[nex][ney] - '0';
            }
        }
        return res;
    }
    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        N = maps.length;
        M = maps[0].length();
        visited = new boolean[N][M];
        arr = new char[N][M];

        for (int i = 0; i < N; i++) {
            String map = maps[i];
            for (int j = 0; j < M; j++) {
                arr[i][j] = map.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] != 'X' && !visited[i][j]) {
                    res = 0;
                    int bfs = bfs(i, j);
                    if (bfs > 0) {
                        answer.add(bfs);    
                    }
                }
            }
        }
        Collections.sort(answer);
        if (answer.size() == 0) {
            answer.add(-1);
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}