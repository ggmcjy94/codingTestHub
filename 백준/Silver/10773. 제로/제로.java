import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < K; i++) {
            int parseInt = Integer.parseInt(br.readLine());
            if (parseInt == 0) {
                stack.pop();
            } else {
                stack.push(parseInt);
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        if (stack.size() == 0) bw.write(0+"");
        int sum = 0;
        for (Integer integer : stack) {
            sum += integer;
        }
        bw.write(sum+"");
        bw.flush();
        bw.close();
    }
   
}