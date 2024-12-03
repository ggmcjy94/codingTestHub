import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {

    static int N , B;


    static class Train{
        int p , k;

        public Train(int p, int k) {
            this.p = p;
            this.k = k;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        Train[] trains = new Train[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            trains[i] = new Train(p, k);
        }


        Arrays.sort(trains, new Comparator<Train>() {
            @Override
            public int compare(Train o1, Train o2) {
                return o2.p - o1.p;
            }
        });

        int ans = 1;
        Train startTrain = trains[0];
        for (int i = 1; i<N; i++) {
            Train nextTrain = trains[i];
            if (nextTrain.k > startTrain.k) {
                startTrain.p = nextTrain.p;
            } else {
                ans++;
            }
        }
        bw.write(ans+"");
        //5
        //0 1
        //1 2
        //2 3
        //3 2
        //6 1


        bw.flush();
        bw.close();
        br.close();
    }

}