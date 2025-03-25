import java.io.*;
import java.util.*;

public class Main {

    static int N,M;
    static int[][] chulMap, copyMap;
    static int cnt;
    static int res;
    //5 10 7 16 2
    //4 22 8 17 13
    //3 18 1 6 25
    //12 19 23 14 21
    //11 24 9 20 15

    //15
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        chulMap = new int[5][5];
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                chulMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cnt = 0;

        int c = 0;
        for (int i =0; i <5 ;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                c++;
                int num = Integer.parseInt(st.nextToken());

                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 5; l++) {
                        if (chulMap[k][l] == num) {
                            chulMap[k][l] = 0;
                        }
                    }
                }
                lcheck();
                rcheck();
                lrCheck();
                rlCheck();
                if (cnt >= 3) {
                    res = c;
                    break;
                }
                cnt=0;
                if (res > 0) break;
            }
            if (res>0) break;
        }
        bw.write(res+"");
        br.close();
        bw.flush();
        bw.close();
    }

    private static void rlCheck() {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            if (chulMap[i][4-i] == 0) count++;
        }
        if (count == 5) {
            cnt++;
        }
    }

    private static void lrCheck() {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            if (chulMap[i][i] == 0) count++;
        }
        if (count == 5) {
            cnt++;
        }
    }

    private static void rcheck() {
        for (int i = 0; i < 5; i++) {
            int count = 0;
            for (int j = 0; j < 5; j++) {
                if (chulMap[j][i] == 0) {
                    count++;
                }
            }
            if (count==5) {
                cnt++;
            }
        }


    }

    private static void lcheck() {
        for (int i = 0; i < 5; i++) {
            int count = 0;
            for (int j = 0; j < 5; j++) {
                if (chulMap[i][j] == 0) {
                    count++;
                }
            }
            if (count == 5)  {
                cnt++;
            }
        }
    }
}