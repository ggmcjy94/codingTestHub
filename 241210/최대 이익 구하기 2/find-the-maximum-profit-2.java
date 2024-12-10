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
    static int res;
    static List<Work> works = new ArrayList<>();
    
    static class Work {
        int T , P;

        public Work(int t, int p) {
            T = t;
            P = p;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            works.add(new Work(T ,P));
        }
        
        //6
        //1 4
        //1 4
        //1 6
        //3 10
        //1 3
        //1 8
        for (int i = 0; i < N; i++) {
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
            int end = i + works.get(i).T;
            if (end <= N) {
                dp[end] = Math.max(dp[end], dp[i]  + works.get(i).P);
            }
        }
        res = dp[N];
        bw.write(res+"");
        bw.flush();
        bw.close();
        br.close();

    }

}