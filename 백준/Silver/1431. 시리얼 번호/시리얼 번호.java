import java.io.*;
import java.util.*;

public class Main {

    static int N,M,C,T,A,B;
    static StringTokenizer st;

    static int[] arr, brr;


    static class Check implements Comparable<Check>{
        String val;
        int sum, length;

        public Check(String val, int sum, int length) {
            this.val = val;
            this.sum = sum;
            this.length = length;
        }

        @Override
        public int compareTo(Check check) {
            if (this.length == check.length && this.sum == check.sum) return this.val.compareTo(check.val);
            if (this.length == check.length) return this.sum - check.sum;
            return this.length - check.length;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N= Integer.parseInt(br.readLine());
        List<Check> list = new ArrayList<>();
        for (int i = 0 ; i < N; i++) {
            String val = br.readLine();
            int length = val.length();
            int sum = 0;
            for (char c : val.toCharArray()) {
                if (Character.isDigit(c)) {
                    sum += Integer.parseInt(String.valueOf(c));
                }
            }

            list.add(new Check(val, sum, length));
        }

        Collections.sort(list);
        for (Check check : list) {
            System.out.println(check.val);
        }
        bw.flush();
        bw.close();
        br.close();
    }

}

