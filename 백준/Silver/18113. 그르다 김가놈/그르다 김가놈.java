import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long K , M;
    static long[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Long.parseLong(st.nextToken());
        M = Long.parseLong(st.nextToken());
        arr = new long[N];
        for (int i = 0; i < N; i++) {
            long l1 = Long.parseLong(br.readLine());
            if (l1 > (2*K)) {
                arr[i] = l1-(2*K);
            }
            if (2*K > l1 && l1 > K) {
                arr[i] = l1-K;
            }
        }

        long l = 1;
        long r = 1000000000;
        long res =-1;
        // 8
        // 4
        while (l <= r) {
            long mid = (l+r) / 2;
            long sum = 0;
            for (long l1 : arr) {
                sum += l1/mid;
            }
            if (sum >= M) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid -1;
            }
        }
        bw.write(res+"");
        bw.flush();
        bw.close();
        br.close();
    }
}