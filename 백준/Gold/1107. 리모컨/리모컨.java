import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static boolean[] broken;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        broken = new boolean[10];
        if (M > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                broken[Integer.parseInt(st.nextToken())] = true;
            }
        }

        int ans = Math.abs(N - 100);


        for (int i = 0; i <= 999999; i++) {
            if(canMake(i)) {
                int press = getDigits(i) + Math.abs(i - N);
                ans = Math.min(ans, press);
            }
        }

        bw.write(ans+"");
        bw.flush();
        bw.close();
        br.close();
    }
    static boolean canMake(int c) {
        if (c == 0) {
            return !broken[0]; // 0 버튼 상태 확인
        }
        while (c > 0) {
            int digit = c % 10;
            if (broken[digit]) {
                return false;
            }
            c /= 10;
        }
        return true;
    }

    static int getDigits(int c) {
        if (c == 0) {
            return 1;
        }
        return (int) Math.floor(Math.log10(c) + 1);
    }
}