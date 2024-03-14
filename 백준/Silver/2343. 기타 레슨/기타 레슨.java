import java.io.*;
import java.util.*;

public class Main {

    static int N,M,C,T,A,B;
    static StringTokenizer st;

    static int[] arr, brr;



    static boolean det(int len) {
        int cnt = 1, sum = 0;
        for (int i = 1; i <=N; i++) {
            if (sum + arr[i] > len) {
                cnt++;
                sum = arr[i];
            } else {
                sum += arr[i];
            }
        }
        return cnt <= M;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int L = arr[1], R = 1000000000 , ans = 0;

        for (int i = 1; i <= N; i++) L = Math.max(L, arr[i]);
        while (L <= R) {
            int mid = (L+R)/2;
            if (det(mid)) {
                ans = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        bw.write(ans+"");
        bw.flush();
        bw.close();
        br.close();
    }

}

