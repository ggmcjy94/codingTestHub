import java.io.*;
        import java.text.SimpleDateFormat;
        import java.util.*;
        import java.util.stream.Collectors;

public class Main {
    static int N,M,Q,T, K,R,C;
    static int[][] tree, dp;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    static class Play implements Comparable<Play>{
        int day, start, end;

        public Play(int day, int start, int end) {
            this.day = day;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Play play) {
            if (this.day == play.day) return this.end - play.end;
            return this.day - play.day;
        }
    }

    //1 1200 1320
    //1 1220 1340
    //2 1155 1220
    //2 1250 1310
    //2 1220 1340
    //2 1330 1550
    //3 1030 1130
    //3 1220 1240
    //3 1130 1300
    //3 1240 1330
    //1 0 700
    //1 500 2200
    //1 2000 2359

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T ; i++) {
            int N = Integer.parseInt(br.readLine());
            ArrayList<Play> plays = new ArrayList<>();
            for (int j = 1; j <= N; j++) {
                st = new StringTokenizer(br.readLine());
                int d = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                plays.add(new Play(d,s,e));
            }
            Collections.sort(plays);
            int cnt = 1;

            Play play;
            play = plays.get(0);
            for (int k = 1; k < N; k++) {
                if (plays.get(k).day == play.day) {
                    int beforeEnd = play.end;
                    int afterStart = plays.get(k).start;
                    if (beforeEnd <= afterStart) {
                        play = plays.get(k);
                        cnt++;
                    }
                } else {
                    play = plays.get(k);
                    cnt++;
                }
            } //1 2 3 4 5 6 7
            bw.write("Scenario #"+i+":\n");
            bw.write(cnt +"\n");
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

}
