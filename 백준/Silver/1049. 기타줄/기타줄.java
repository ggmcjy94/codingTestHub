import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        // 15 1
        // 100 6  40 1
        // 200 12 80 2
        // 300 18 120 3
        List<Integer> pList = new ArrayList<>();
        List<Integer> qList = new ArrayList<>();
        for (int i = 0; i< M; i++) {
            st = new StringTokenizer(br.readLine() , " ");
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            pList.add(p);
            qList.add(d);
        }
        Collections.sort(pList);
        Collections.sort(qList);
//9 16
//3 8
        int min = 0;
        int bmin = 0;
        int bN = N;
        int cmin = 0;
        int cN = N;
        while (N > 0) {
            N -= 6;
            min += pList.get(0);
        }

        while (bN > 0) {
            if (bN >= 6) {
                bN -= 6;
                bmin += pList.get(0);
            }else {
                bN -= 1;
                bmin += qList.get(0);
            }
        }
        while (cN > 0) {
            cN -= 1;
            cmin += qList.get(0);
        }
        int minned = Math.min(Math.min(min, bmin), cmin);
        bw.write(minned+"");
        bw.flush();
        bw.close();
    }
}