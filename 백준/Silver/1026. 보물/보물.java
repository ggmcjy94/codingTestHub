import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //5
        //1 1 1 6 0
        //2 7 8 3 1
        // 6 1 1 1 0
        // 1 2 3 7 8
        // 6 2 3 7
        //18
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Integer[] A = new Integer[N];
        int[] B = new int[N];
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                if (i == 0) A[j] = Integer.parseInt(st.nextToken());
                else B[j] = Integer.parseInt(st.nextToken());
            }
        }
        Arrays.sort(A, Collections.reverseOrder());
        Arrays.sort(B);
        int sum = 0;
        for (int i =0; i<N; i++) {
            sum += A[i] * B[i];
        }
        bw.write(sum + "");
        bw.flush();
        bw.close();
    }
}