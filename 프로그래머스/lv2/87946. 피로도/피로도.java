import java.util.*;
class Solution {
     static boolean[] visited;
    static int answer = -1;
    public int solution(int k, int[][] dungeons) {
        //80	[[80,20],[50,40],[30,10]]	3

        visited = new boolean[dungeons.length];
        dfs(k, dungeons,0);
        return answer;
    }

    private void dfs(int k, int[][] dungeons, int c) {
        answer = Math.max(answer, c);
        for (int i = 0; i < dungeons.length; i++) {
            if (dungeons[i][0] <= k && !visited[i]) {
                visited[i] = true;
                dfs(k - dungeons[i][1] , dungeons, c+1);
                visited[i] = false;
            }
        }
    }
}