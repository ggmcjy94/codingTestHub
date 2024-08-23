import java.io.*;
import java.util.*;

public class Main {
//5 8 20
//5 8 17
//0 0 0

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int cnt = 1;
        while (true){
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            if (L==0 && P==0 && V==0) break;
            int total = L * (V / P) + Math.min(L, V % P);

            bw.write("Case "+ cnt +": "+total +"\n");
            cnt++;
        }
        br.close();
        bw.flush();
        bw.close();
    }

}