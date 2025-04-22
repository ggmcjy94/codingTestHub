import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sb.append(search(Integer.parseInt(st.nextToken()))).append('\n');
        }
        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    private static int search(int x) {
        int L = 0;
        int R = N-1;
        //4 1 5 2 3
        // 1 2 3 4 5
        while (L <= R) {
            int mid = (L+R)/2;
            if (arr[mid] == x) {
                return 1;
            }
            if (arr[mid] >= x) {
                R = mid-1;
            } else {
                L = mid+1;
            }
        }
        return 0;

    }

}