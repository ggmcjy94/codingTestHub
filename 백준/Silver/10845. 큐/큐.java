import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));
        int read = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new LinkedList<>();
        StringTokenizer st;
        for (int i = 0; i < read; i++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "push":
                    queue.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    int result = blankNum(queue) ? -1 : queue.poll();
                    bw.write(result+"\n");
                    break;
                case "size" :
                    bw.write(queue.size() + "\n");
                    break;
                case "empty":
                    int emp = queue.isEmpty() ? 1 : 0;
                    bw.write(emp + "\n");
                    break;
                case "front":
                    int fr = blankNum(queue)? -1 : queue.peek();
                    bw.write(fr+"\n");
                    break;
                case "back":
                    int ba = blankNum(queue)? -1 : queue.peekLast();
                    bw.write(ba+"\n");
                    break;
                default:
                    break;
            }
        }
        bw.flush();
        bw.close();
    }

    private static boolean blankNum(Queue<Integer> queue) {
        return queue.size() == 0;
    }
}