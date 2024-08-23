import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String line = br.readLine();
        boolean[] eats = new boolean[N];
        char[] arr;
        arr = line.toCharArray();
        int res = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] == 'P') {

                for (int j = -K; j <= K; j++){
                    if (i + j >= N) continue;
                    if (i+ j < 0) continue;
                    if (arr[i+j] == 'H' && !eats[i+j]) {
                        eats[i+j] = true;
                        res++;
                        break;
                    }
                }
            }
        }
        bw.write(res+"\n");
        br.close();
        bw.flush();
        bw.close();
    }

}