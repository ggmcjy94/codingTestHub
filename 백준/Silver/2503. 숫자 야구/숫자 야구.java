import java.io.*;
import java.util.*;

public class Main {

    static int N,M;
    static int[][] chulMap, copyMap;
    static int cnt;
    static int res;

    static class Point {
        String num;
        int strike,ball;

        public Point(String num, int strike, int ball) {
            this.num = num;
            this.strike = strike;
            this.ball = ball;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        Point[] points = new Point[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String num = st.nextToken();
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            points[i] = new Point(num, strike, ball);
        }

        int ans =0;
        for (int x = 1; x <= 9; x++) {
            for (int y = 1; y<=9; y++) {
                for (int z = 1; z<=9;z++) {
                    if (x != y &&  x != z  && y!= z) {

                        int count = 0;
                        for (int i = 0; i < N ; i++) {
                            Point point = points[i];

                            int strike = 0;
                            int ball = 0;

                            int a = point.num.charAt(0)-'0';
                            int b = point.num.charAt(1)-'0';
                            int c = point.num.charAt(2)-'0';

                            if (a == x) {
                                strike++;
                            } else if (a == y) {
                                ball++;
                            } else if (a == z) {
                                ball++;
                            }


                            if (b == x) {
                                ball++;
                            } else if (b == y) {
                                strike++;
                            } else if (b == z) {
                                ball++;
                            }

                            if (c == x) {
                                ball++;
                            } else if (c == y) {
                                ball++;
                            } else if (c == z) {
                                strike++;
                            }

                            if (strike == points[i].strike && ball == points[i].ball) {
                                count++;
                            }
                        }
                        if (count == N) {
                            ans++;
                        }
                    }
                }
            }
        }

        bw.write(ans+"");


        br.close();
        bw.flush();
        bw.close();
    }
}