import java.io.*;
import java.util.*;

public class Main {
    static int M,N;

    static long[] arr;
    static long res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new long[N];
        st = new StringTokenizer(br.readLine());
        long maxTime = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            maxTime = Math.max(arr[i], maxTime);
        }
        long l = 0;
        long r = M * maxTime;
        while (l <= r) {
            long mid = (l+r)/2;
            long cnt = 0;
            for (long i : arr) {
                cnt += (mid/i);
            }

            if (cnt >= M) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid+1;
            }
        }
        bw.write(res+"");
        bw.flush();
        bw.close();
        br.close();
    }
}