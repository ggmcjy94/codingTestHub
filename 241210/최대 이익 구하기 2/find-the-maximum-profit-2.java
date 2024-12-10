import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {

    static int N , M, S;
    static int [][] map;
    static int[] arr;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static boolean[][] visited;
    static boolean[] visit;
    static int res;
    static List<Work> works = new ArrayList<>();

    static class Work {
        int T , P;

        public Work(int t, int p) {
            T = t;
            P = p;
        }
    }


    static void back(int cur, int point) {
        if (cur > N) return;

        if (point > res) res = point;

        for (int i = cur; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                back(i + works.get(i).T, point + works.get(i).P);
                visit[i] = false;
            }

        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        
        visit = new boolean[N+1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            works.add(new Work(T ,P));
        }
        back(0,0);
        bw.write(res+"");
        bw.flush();
        bw.close();
        br.close();

    }

}