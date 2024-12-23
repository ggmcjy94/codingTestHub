import java.io.*;
import java.util.*;

public class Main {

    static int N , M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        List<Double> arr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            arr.add(Double.parseDouble(st.nextToken()));
        }
        Collections.sort(arr);
        // 2 4 6 8

        // 4 6 9

        while (arr.size() != 1) {
            double min = arr.get(0) / 2;
            double max = arr.get(arr.size() - 1);
            double sum = min + max;
            arr.remove(0);
            arr.remove(arr.size() - 1);
            arr.add(sum);
        }
        bw.write(Math.ceil(arr.get(0))+"");




        bw.flush();
        bw.close();
        br.close();
    }

}