import java.io.*;
import java.util.*;

public class Main {

    static class Exam  {
        int f , m;

        public Exam(int i, int q) {
            this.f = i;
            this.m = q;
        }

    }

    static List<Exam> examList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int p = 8;
        solution(p,br);
    }
    private static void solution(int p, BufferedReader br) throws IOException {
        for (int i = 1; i <= p; i++) {
            int q = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
            examList.add(new Exam(i, q));
        }
        examList.sort((o1, o2) -> o2.m-o1.m);
        int sum = 0;
        int [] answer = new int[5];
        for (int i = 0; i < 5; i++) {
            sum += examList.get(i).m;
            answer[i] = examList.get(i).f;
        }
        Arrays.sort(answer);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sum + "\n");
        for (int i : answer) {
            bw.write(i + " ");
        }
        bw.flush();
        bw.close();
    }
}