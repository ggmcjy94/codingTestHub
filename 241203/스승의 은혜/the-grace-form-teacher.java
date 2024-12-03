import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {

    static int N , B;


    static class Rocket implements Comparable<Rocket>{
        int p, v, s;

        public Rocket(int p, int v, int s) {
            this.p = p;
            this.v = v;
            this.s = s;
        }


        @Override
        public int compareTo(Rocket o) {
            if (this.s == o.s) return this.p - o.p;
            return this.s - o.s;
        }
    }

    //5 24
    //2 0  2
    //4 2  6
    //6 3  9
    //8 1  9
    //12 5 17

    //
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        List<Rocket> rockets = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            rockets.add(new Rocket(p, v, p+v));
        }
        Collections.sort(rockets);

        boolean device = false;
        int cnt = 0;
        int sum = 0;
        for (Rocket rocket : rockets) {
            if (sum >= B) {
                if (!device) {
                    sum -= rocket.p / 2;
                    device = true;
                } else {
                    break;
                }
            } else {
                sum += rocket.s;
                cnt++;
            }
        }


        bw.write(cnt+"");

        bw.flush();
        bw.close();
        br.close();
    }

}