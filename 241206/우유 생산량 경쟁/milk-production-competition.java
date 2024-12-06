import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {

    static int N , B, res;

    //4
    //7 Mildred +3
    //4 Elsie -1
    //9 Mildred -1
    //1 Bessie +2


    static class Cow {

        String name;
        Integer cnt;

        public Cow(String name, Integer cnt) {
            this.name = name;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        Cow[] cows = new Cow[101];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            String n = st.nextToken();
            int r = Integer.parseInt(st.nextToken());
            cows[d] = new Cow(n, r);
        }
        //1 : Bessie : 2
        //4 : Elsie : -1
        //7 : Mildred : 3
        //9 : Mildred : -1

        String bessie = "Bessie";
        String elsie = "Elsie";
        String mildred = "Mildred";

        int[] score = new int[]{7, 7, 7};
        int[] prev = new int[]{1,1,1};
        for (int i = 0; i < 101; i++) {
            if (cows[i] == null) continue;

            if (cows[i].name.equals(bessie)) {
                score[0] += cows[i].cnt;
            } else if (cows[i].name.equals(elsie)) {
                score[1] += cows[i].cnt;
            } else {
                score[2] += cows[i].cnt;
            }

            int max = Math.max(score[0], Math.max(score[1], score[2]));


            int[] temp = new int[3];
            for (int j= 0; j < 3; j++) {
                if (score[j] == max) temp[j] = 1;
            }

            boolean check = false;
            for (int j = 0; j < 3; j++) {
                if (prev[j] != temp[j])  {
                    check = true;
                }
            }
            if (check) res++;
            prev = Arrays.copyOf(temp, 3);
        }
        bw.write(res+"");

        bw.flush();
        bw.close();
        br.close();
    }

}