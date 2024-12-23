import java.io.*;
import java.util.*;

public class Main {

    static int N , M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        // 2 4 6 8
        double sum = arr[N-1];
        for (int i = N-2; i  >= 0; i--) {
            double a = (double) arr[i] / 2;
            sum += a;
        }
        bw.write(String.format("%.1f", sum));
        bw.flush();
        bw.close();
        br.close();
    }

}