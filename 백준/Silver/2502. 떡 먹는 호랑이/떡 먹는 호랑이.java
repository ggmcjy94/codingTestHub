import java.io.*;
import java.util.*;

public class Main {

    static int R, C,K;
    static int ans;
    static char[][] map;
    static int[][] copyMap;
    static boolean[][] visited;
    static int[] dx = {0 , 1 , 0 , -1};
    static int[] dy = {1 , 0 , -1, 0};


    //7 218
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[] dp = new int[A];
        boolean a = false;
        for (int i = 1; i <= B/2; i++) {
            for (int j = i+1; j < B; j++) {
                dp[0] = i;
                dp[1] = j;
                for (int k = 2; k < A; k++) {
                    dp[k] = dp[k-1] + dp[k-2];
                }

                if (dp[A-1] == B) {
                    R = dp[0];
                    C = dp[1];
                    a = true;
                    break;
                }
            }
            if (a) break;
        }

        bw.write(R+"\n"+C);
        bw.flush();
        bw.close();
        br.close();
    }

}