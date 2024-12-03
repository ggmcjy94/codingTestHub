import java.io.*;
import java.sql.Array;
import java.util.*;

public class Main {

    static int N , B;

    static class Point implements Comparable<Point>{
        int index , v;

        public Point(int index, int v) {
            this.index = index;
            this.v = v;
        }

        @Override
        public int compareTo(Point o) {
            return o.v - this.v;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        Queue<Point> queue = new LinkedList<>();
        PriorityQueue<Point> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N ; i++) {
            int e = Integer.parseInt(st.nextToken());
            queue.add(new Point(i, e));
            pq.offer(new Point(i, e));
        }

        //6 0
        //1 1 9 1 1
        int cnt = 0;
        while (!queue.isEmpty() && !pq.isEmpty()) {
            Point peek = queue.peek();
            Point pqeek = pq.peek();
            if (peek.v < pqeek.v) {
                Point poll = queue.poll();
                queue.offer(new Point(poll.index, poll.v));
            } else {
                Point poll = queue.poll();
                Point poll1 = pq.poll();
                cnt++;
                if (poll.index == B) break;
            }
        }

        //6 0
        //1 1 9 1 1 1
        bw.write(cnt+"");
        bw.flush();
        bw.close();
        br.close();
    }

}