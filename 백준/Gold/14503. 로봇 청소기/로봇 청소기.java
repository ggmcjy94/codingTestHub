import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.*;

public class Main {

    static int N,Q,M,C,R,T,A,B,X,Y,D;
    static int ans;
    static StringTokenizer st;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] arr;
    static boolean[][] visited;


    static void clean(int x, int y , int d) {
        arr[x][y] = -1;

        for (int i = 0; i < 4; i ++) {
            d = (d+3) % 4;
            int nex = x + dx[d];
            int ney = y + dy[d];
            if (ney >= 0 && ney < M  && nex >= 0 && nex < N) {
                if (arr[nex][ney] == 0) {
                    ans++;
                    clean(nex, ney, d);
                    return;
                }

            }
        }

        int b = (d + 2) % 4;
        int bx = x + dx[b];
        int by = y + dy[b];

        if (by >= 0 && bx >= 0 && by < M && bx < N && arr[bx][by] != 1) {
            clean(bx,by,d);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans = 1;
        clean(X,Y,D);
        bw.write(ans+"");
        bw.flush();
        bw.close();
        br.close();

    }

}

