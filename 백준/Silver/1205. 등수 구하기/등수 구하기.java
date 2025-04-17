import java.io.*;
import java.util.*;

public class Main {

    static int N,M,P;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        int[] s = new int[P];
        if (N > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                s[i] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(s);

        if(P==N && s[0]>=M){
            System.out.println(-1);
            return;
        }

        int cnt = 1;
        for(int i=P-1;i>=Math.max(0,P-N-1);i--){
            if(s[i]>M) {
                cnt++;
            } else {
                break;
            }
        }
        System.out.println(cnt);
        br.close();
        bw.flush();
        bw.close();
    }
}