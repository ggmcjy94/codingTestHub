import java.io.*;
import java.util.*;

public class Main {

    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String fun = st.nextToken();
            switch (fun) {
                case "push":
                    queue.offer(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if(queue.isEmpty()) {
                        sb.append("-1").append('\n');
                    } else {
                        sb.append(queue.poll()).append('\n');
                    }

                    break;
                case "size":
                    sb.append(queue.size()).append('\n');
                    break;
                case "empty":
                    if(queue.isEmpty()) {
                        sb.append("1").append('\n');
                    } else {
                        sb.append("0").append('\n');
                    }
                    break;
                case "front":
                    if(queue.isEmpty()) {
                        sb.append("-1").append('\n');
                    } else {
                        sb.append(queue.peekFirst()).append('\n');
                    }
                    break;
                case "back":
                    if(queue.isEmpty()) {
                        sb.append("-1").append('\n');
                    } else {
                        sb.append(queue.peekLast()).append('\n');
                    }
                    break;
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

}