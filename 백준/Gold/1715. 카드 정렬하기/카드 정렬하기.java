import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //3
        //10
        //20
        //40
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<Long>();
        for (int i = 0; i < N; i++) {
            pq.add(Long.parseLong(br.readLine()));
        }
        //(10 + 20) + (30 + 40) = 100
        long sum = 0;
        while (pq.size() > 1) {
            Long t1 = pq.poll();
            Long t2 = pq.poll();

            sum += t1 + t2;
            pq.add(t1 + t2);
        }
        bw.write(sum + "");
        bw.flush();
        bw.close();
    }
}