import java.io.*;
import java.util.*;

public class Main {

    static int  N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());
            if(a == 0) {
                if (queue.isEmpty()){
                    bw.write("0\n");
                } else {
                    bw.write(queue.poll()+"\n");
                }
            } else {
                queue.offer(a);
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }


}