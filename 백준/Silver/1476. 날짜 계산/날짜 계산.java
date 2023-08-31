import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        1 ≤ E ≤ 15, 1 ≤ S ≤ 28, 1 ≤ M ≤ 19)
        StringTokenizer st;
        int je=1,js=1,jm=1;
        st = new StringTokenizer(br.readLine(), " ");
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int cnt = 1;
//        1 16 16
        // 1 1 1
        while (true) {
            if (je==E &&js==S &&jm==M) break;
            je++; js++; jm++;
            if (je > 15) je=1;
            if (js > 28) js =1;
            if (jm > 19) jm =1;
            cnt++;
        }
        bw.write(cnt +"");
        bw.flush();
        bw.close();
    }
}