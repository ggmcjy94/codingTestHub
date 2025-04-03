import java.io.*;
import java.util.*;

public class Main {

    static int N,M,T;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        st= new StringTokenizer(br.readLine());
        // 3
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N ; i++ ) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, Collections.reverseOrder());

        int cnt =0;
        while (true) {
            if (arr.length==1) {
                cnt = arr[0];
                break;
            }
            // 4
            // 5 2 1
            // 4 1 1
            // 3 0 1
            // 2 0 0
            if (arr[1] == 0) {
                cnt+= arr[0];
                break;
            }

            arr[0]--;
            if (arr[1]>0) {
                arr[1]--;
            }
            cnt++;
            Arrays.sort(arr, Collections.reverseOrder());
        }

        if (cnt > 1440) {
            bw.write("-1");
        } else {
            bw.write(cnt+"");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}