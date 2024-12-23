import java.io.*;
import java.util.*;

public class Main {

    static int N , M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] arr = new int[M];
        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = a*b;
            arr[i] = c;
        }

        Arrays.sort(arr);
        int cnt = 0;
        for (int i = M-1; i >= 0; i--) {
            N -= arr[i];
            cnt++;
            if (N <= 0) break;
        }


        //20 3
        //2 7 14
        //3 2 6
        //1 5 5

        // 2
        bw.write(cnt+"");
        bw.flush();
        bw.close();
        br.close();
    }

}