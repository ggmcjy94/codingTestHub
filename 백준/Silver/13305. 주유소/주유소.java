import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        long[] dis = new long[N-1];
        long[] cost = new long[N];
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N-1; i++) {
            int c = Integer.parseInt(st.nextToken());
            dis[i] = c;
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }
        //4
        //2 3 1
        //5 2 4 1
        //18
        long sum = cost[0] * dis[0];
        for (int i = 1; i < N-1; i++) {
            if (cost[i] >= cost[i-1]) {
                sum += cost[i-1] * dis[i];
            } else {
                sum += cost[i] * dis[i];
            }
        }
        bw.write(sum +"");


        bw.flush();
        bw.close();

    }
}