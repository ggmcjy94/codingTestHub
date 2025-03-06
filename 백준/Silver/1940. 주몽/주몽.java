import java.io.*;
import java.util.*;

public class Main {

    static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int cnt = 0;
        int l = 0;
        int r = N-1;
        // 1 2 3 4 5 7
        while (l < r) {
            int a = arr[l] + arr[r];
            if (a==M) {
                cnt++;
                l++;
                r--;
                continue;
            }

            if (a < M) {
                l++;
            }
            if (a > M) {
                r--;
            }
        }
        bw.write(cnt+"");
        br.close();
        bw.flush();
        bw.close();
    }


}