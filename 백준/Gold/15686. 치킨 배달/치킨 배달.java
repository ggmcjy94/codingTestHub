import java.io.*;
import java.util.*;

public class Main {


    static int N,M;
    static List<int[]> houses;
    static List<int[]> chickens;
    static boolean[] selected;
    static int minDistance = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st  = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        houses = new ArrayList<>();
        chickens = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int d = Integer.parseInt(st.nextToken());

                if (d == 1) {
                    houses.add(new int[]{i,j});
                } else if (d==2) {
                    chickens.add(new int[]{i,j});
                }
            }
        }
        selected = new boolean[chickens.size()];
        for (int i = 1;  i<= M; i++) {
            combi(0,0,i);
        }
        bw.write(minDistance+"");

        bw.flush();
        bw.close();
        br.close();


    }


    static void combi(int start, int depth, int count) {
        if (depth == count) {
            calculateDistance();
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            if (!selected[i]) {
                selected[i] = true;
                combi(i + 1, depth + 1, count);
                selected[i] = false;
            }
        }

    }

    static void calculateDistance() {
        int totalDistance = 0;
        for (int[] house : houses) {
            int hx = house[0], hy = house[1];
            int minDist = Integer.MAX_VALUE;
            for (int i = 0; i < chickens.size(); i++) {
                if (selected[i]) {
                    int cx = chickens.get(i)[0], cy = chickens.get(i)[1];
                    int dist = Math.abs(hx - cx) + Math.abs(hy - cy);
                    minDist = Math.min(minDist, dist);
                }
            }

            totalDistance += minDist;
        }

        // 최소 치킨 거리 합 갱신
        minDistance = Math.min(minDistance, totalDistance);

    }



}