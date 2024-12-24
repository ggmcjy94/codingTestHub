import java.io.*;
import java.util.*;

public class Main {

    static int N , M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        //6 10
        //4 4 4 4 4 4
        //3


        int cnt = 1;
        int sum = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int w = Integer.parseInt(st.nextToken());
            if (sum + w <= M) {
                sum+=w;
                continue;
            }

            cnt++;
            sum = w;
        }


        bw.write(cnt+"");
        bw.flush();
        bw.close();
        br.close();
    }

}