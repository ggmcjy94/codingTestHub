import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static int[][] map;
    static int[] dx = {-1,-1,-1,0,0,1,1,1};
    static int[] dy = {-1,0,1,-1,1,-1,0,1};
    static boolean[][] visited;
    static boolean[][] top;
    static int w = 0;
    //기본) 스택,큐,우선순위큐,Deque(★),해시맵,문자열
    //초급) PriorityQueue 완전탐색
    //중급) BinarySearch DFS BFS Recursion
    //심화) Graph DP

    //8 7
    //4 3 2 2 1 0 1
    //3 3 3 2 1 0 1
    //2 2 2 2 1 0 0
    //2 1 1 1 1 0 0
    //1 1 0 0 0 1 0
    //0 0 0 1 1 1 0
    //0 1 2 2 1 1 0
    //0 1 1 1 2 1 0
    static void bfs(int r, int c) {
        visited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r,c});
        visited[r][c] = true;
        ArrayList<int[]> topList = new ArrayList<>();
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int nox = poll[0];
            int noy = poll[1];
            for (int i = 0; i < 8; i++) {
                int nex = dx[i] + nox;
                int ney = dy[i] + noy;
                if (nex<0 || nex>= N || ney <0 || ney>=M) continue;
                if (visited[nex][ney])continue;
                if (map[nex][ney] > map[nox][noy]) {
                    return;
                } else if (map[nex][ney] == map[nox][noy]) {
                    queue.add(new int[]{nex, ney});
                    topList.add(new int[]{nex,ney});
                }
                visited[nex][ney] = true;
            }
        }

        for (int i = 0; i < topList.size(); i++) {
            int[] ints = topList.get(i);
            top[ints[0]][ints[1]] = true;
        }
        w++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        top=new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0&&!top[i][j]) {
                    bfs(i, j);
                }
            }
        }
        bw.write(w+"");
        bw.flush();
        bw.close();
        br.close();
    }
}