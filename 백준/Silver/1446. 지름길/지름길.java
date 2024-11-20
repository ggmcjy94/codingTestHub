import java.io.*;
import java.util.*;

public class Main {

    static int N, D;
    static int[][] map;
    static int[][] copyMap;
    static boolean[][] visited;
    static int[] dx = {0 , 1 , 0 , -1};
    static int[] dy = {1 , 0 , -1, 0};

    static class Highway implements Comparable<Highway>{
        int start,end,dis;

        public Highway(int start, int end, int dis) {
            this.start = start;
            this.end = end;
            this.dis = dis;
        }

        @Override
        public int compareTo(Highway o) {
            if (o.start==this.start) return this.end-o.end;
            return this.start-o.start;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        int[] distance = new int[D+1];
        Arrays.fill(distance, 10001);
        List<Highway> highwayList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
            if (end > D || end-start <= dis) continue;
            highwayList.add(new Highway(start,end,dis));
        }

        Collections.sort(highwayList);
        int arrayIdx =0;
        int location =0;
        distance[0] = 0;

        while (location < D) {
            if (arrayIdx < highwayList.size()) {
                Highway highway = highwayList.get(arrayIdx);
                if (highway.start == location) {
                    distance[highway.end] = Math.min(distance[highway.end], distance[location]+ highway.dis);
                    arrayIdx++;
                    continue;
                }
            }
            distance[location+1] = Math.min(distance[location+1],distance[location]+1);
            location++;
        }
        bw.write(distance[D]+"");
        bw.flush();
        bw.close();
        br.close();

    }

}