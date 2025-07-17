import java.io.*;
import java.util.*;

public class Main {
    static int M,N;

    static long[][] arr;
    static long res;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new long[N][N];
        long maxValue = 0;
        long sum = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                sum += arr[i][j];
                maxValue = Math.max(arr[i][j], maxValue);
            }
        }

        long l = 0;
        long r = maxValue;
//        long target = (sum + 1) / 2;
        while (l < r) { // 80
            long mid = (l+r) / 2;
            long cnt = 0;
            for (long[] ints : arr) {
                for (long anInt : ints) {
                    cnt += Math.min(anInt, mid);
                }
            }
            if (cnt*2 >= sum) {
                r = mid;
            } else {
                l = mid+1;
            }
        }
        bw.write(r+"");
        bw.flush();
        bw.close();
        br.close();
    }
}