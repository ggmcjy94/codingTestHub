import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();
        //push X: 정수 X를 큐에 넣는 연산이다.
        //pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        //size: 큐에 들어있는 정수의 개수를 출력한다.
        //empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
        //front: 큐의 가장 앞에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        //back: 큐의 가장 뒤에 있는 정수를 출력한다. 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            switch (st.nextToken()){
                case "push":
                    deque.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if (deque.isEmpty()) {
                        bw.write( "-1\n");
                    } else {
                        bw.write(deque.pop() + "\n");
                    }
                    break;
                case "size":
                    bw.write(deque.size()+"\n");
                    break;
                case "empty":
                    if (deque.isEmpty()) {
                        bw.write(1+"\n");
                    } else {
                        bw.write(0 + "\n");
                    }
                    break;
                case "front":
                    if (deque.isEmpty()) {
                        bw.write( "-1\n");
                    } else {
                        bw.write(deque.getFirst() + "\n");
                    }
                    break;
                case "back":
                    if (deque.isEmpty()) {
                        bw.write( "-1\n");
                    } else {
                        bw.write(deque.getLast() + "\n");
                    }
                    break;
            }
        }

        //15
        //push 1
        //push 2
        //front 1
        //back 2
        //size 2
        //empty 0
        //pop 1
        //pop 2
        //pop -1
        //size 0
        //empty 1
        //pop -1
        //push 3
        //empty 0
        //front 3
        //1
        //2
        //2
        //0
        //1
        //2
        //-1
        //0
        //1
        //-1
        //        //0

        bw.flush();
        bw.close();
    }
}