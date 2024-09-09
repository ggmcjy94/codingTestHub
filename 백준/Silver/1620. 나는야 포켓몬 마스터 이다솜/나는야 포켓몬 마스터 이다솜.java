import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer , String> map = new HashMap<>();
        Map<String , Integer> map2 = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            map.put(i, name);
            map2.put(name, i);
        }

        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            boolean digitCheck = isDigitCheck(s);
            if (digitCheck) {
                bw.write(map.get(Integer.parseInt(s))+"\n");
            } else {
                bw.write(map2.get(s)+"\n");
            }


        }
        br.close();
        bw.flush();
        bw.close();
    }

    private static boolean isDigitCheck(String s) {
        boolean isNumeric = true;

        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                isNumeric = false;
            }
        }
        return isNumeric;
    }


}