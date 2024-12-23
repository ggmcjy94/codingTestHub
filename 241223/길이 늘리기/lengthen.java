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
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for (int i : arr) {
            if (M >= i) {
                M += 1;
            } else {
                break;
            }
        }
        bw.write(M+"");

//9 1
//9 5 8 1 3 2 7 6 4
        //10


        bw.flush();
        bw.close();
        br.close();
    }

}