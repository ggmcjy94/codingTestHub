import java.io.*;
import java.util.*;

public class Main {

    static class Meet{
        int s, e;

        public Meet(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Meet> meetList = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int fs = Integer.parseInt(st.nextToken());
            int es = Integer.parseInt(st.nextToken());
            meetList.add(new Meet(fs, es));
        }
        int lastGo;
        int startOut;
        meetList.sort((o1, o2) -> o2.s - o1.s);
        lastGo = meetList.get(0).s;
        meetList.sort(Comparator.comparingInt(o -> o.e));
        startOut = meetList.get(0).e;

        int sum = 0;
        if (lastGo >= startOut) {
            sum = lastGo - startOut;
        }
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}