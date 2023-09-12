import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //10
        //1 4 2 3 1 4 2 3 1 2
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < T; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        for (Integer i : set) {
            bw.write(i + " ");
        }
        bw.flush();
        bw.close();
    }
}