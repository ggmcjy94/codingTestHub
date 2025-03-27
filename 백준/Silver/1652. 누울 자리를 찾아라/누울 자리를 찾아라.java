import java.io.*;
import java.util.*;

public class Main {

    static int N,M;


    //5
    //....X
    //..XX.
    //.....
    //.XX..
    //X....
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int row = 0;
        int col = 0;
        char[][] map = new char[N][N];

        for (int i = 0; i < N; i++) {
            int cnt=0;
            String s = br.readLine();
            // ....X
            for (int j = 0; j < N; j++) {
                char c = s.charAt(j);
                map[i][j] = c;
                if (c == 'X') {
                    cnt = 0;
                    continue;
                }
                if (c == '.') {
                    cnt++;
                    if (cnt > 2) continue;
                }
                if (cnt>=2) {
                    row++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            int ccnt=0;
            for (int j = 0; j < N; j++) {
                char c = map[j][i];
                if (c == 'X') {
                    ccnt = 0;
                    continue;
                }
                if (c == '.') {
                    ccnt++;
                    if (ccnt > 2) continue;
                }
                if (ccnt>=2) {
                    col++;
                }
            }
        }
        bw.write(row+" "+col);




        br.close();
        bw.flush();
        bw.close();
    }
}