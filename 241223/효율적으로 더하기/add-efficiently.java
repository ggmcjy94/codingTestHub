import org.omg.CORBA.OMGVMCID;

import java.io.*;
import java.util.*;

public class Main {

    static int N , M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());


        int [] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int sum = 0;
        for (int i = 0; i < N; i++) {
            int ans = arr[i];
            for (int j = 0; j < i; j++) {
                ans += arr[j];
            }
            sum += ans;
        }
        bw.write(sum+"");
        bw.flush();
        bw.close();
        br.close();
    }

}