import java.io.*;
import java.util.*;

public class Main {

    static int N,M,C,R,T,A,B;
    static int ans;
    static StringTokenizer st;
    static int[] dx = {1,0,-1,0,1,-1,-1,1};
    static int[] dy = {0,1,0,-1,1,1,-1,-1};
    static int[] arr, brr;
    static ArrayList<Integer>[] graph;
    static char[][] map;
    static Queue<int[]> iceQueue;
    static boolean[][] visited;
    static boolean[] visit;
    static int[] dist;
    static StringBuilder sb = new StringBuilder();
    static class Point {
        int pos, tar;

        public Point(int pos, int tar) {
            this.pos = pos;
            this.tar = tar;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st =  new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        T = Integer.parseInt(br.readLine());
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int pos = Integer.parseInt(st.nextToken());
            int tar = Integer.parseInt(st.nextToken());
            points.add(new Point(pos, tar));
        }
        st = new StringTokenizer(br.readLine());
        int myPos = Integer.parseInt(st.nextToken());
        int myTar = Integer.parseInt(st.nextToken());
        int sum = 0;
        for (Point point : points) {
            if (myPos == point.pos) {
                int val = Math.abs(myTar - point.tar);
                sum += val;
            } else {
                if (myPos == 1) {
                    if (point.pos == 4) {
                        int val = N - point.tar + myTar;
                        sum += val; // 4 2
                    } else if (point.pos == 3) {
                        int val = point.tar + myTar;
                        sum += val;
                    } else {
                        // 1 3
                        int val = Math.min(myTar + M + point.tar, N - myTar + M + N - point.tar);
                        sum += val;
                    }
                }

                if (myPos == 2) {
                    if (point.pos == 4) {
                        int val = N - myTar + M - point.tar;
                        sum += val; // 4 2
                    } else if (point.pos == 3) {
                        int val = myTar + M - point.tar;
                        sum += val;
                    } else {
                        // 1 3
                        int val = Math.min(myTar + M + point.tar, N - myTar + M + N - point.tar);
                        sum += val;
                    }
                }

                if (myPos == 3) {
                    if (point.pos == 1) {
                        int val = myTar + point.tar;
                        sum += val;
                    } else if (point.pos == 2) {
                        int val = M - myTar + point.tar;
                        sum += val;
                    } else {
                        int val = Math.min(myTar+N+point.tar, M - myTar + N + M - point.tar);
                        sum += val;
                    }
                }


                if (myPos == 4) {
                    if (point.pos == 1) {
                        int val = myTar + N - point.tar;
                        sum += val;
                    } else if (point.pos == 2) {
                        int val = M - myTar + N - point.tar;
                        sum += val;
                    } else {
                        int val = Math.min(myTar+N+point.tar, M - myTar + N + M - point.tar);
                        sum += val;
                    }
                }
            }

        }
        //10 5
        //3
        //1 4
        //3 2
        //2 8
        //1 3

        // 1
        // 5
        // 14
        // 20

        bw.write(sum+"");
        bw.flush();
        bw.close();
        br.close();

    }

}

