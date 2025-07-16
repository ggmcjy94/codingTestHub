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
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new long[N];
        st = new StringTokenizer(br.readLine());
        long max = 0;
        for (int i = 0; i < N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(arr[i],max);
        }

        long l = 1;
        long r = max;
        while (l <= r) {
            long mid = (l+r)/2;
            long count = 0;
            for (long l1 : arr) {
                count += l1/mid;
            }

            if (count >= M) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid -1;
            }
        }


        //3 10
        //1 2 3 4 5 6 7 8 9 10
        bw.write(res+"");
        bw.flush();
        bw.close();
        br.close();
    }
}