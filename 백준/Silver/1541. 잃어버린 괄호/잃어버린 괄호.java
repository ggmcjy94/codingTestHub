import java.io.*;
import java.util.*;

public class Main {
    static int N, M, res;
    static int[] vol,tel;
    static int[][] dp, arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String N = br.readLine();
        int sum = 0;
        //30-70-(60)-(140)-35
        //30-70-60-140-35
        //30-70-20+40-10+100+30-35
        if (N.contains("-")) {
            String[] split = N.split("\\-");
            if (split[0].contains("+")) {
                String[] split1 = split[0].split("\\+");
                for (int i = 0; i < split1.length; i++) {
                    sum += Integer.parseInt(split1[i]);
                }
            } else {
                sum = Integer.parseInt(split[0]);
            }

            for (int i = 1; i < split.length; i++) {
                if (split[i].contains("+")) {
                    String[] s = split[i].split("\\+");
                    int plus = 0;
                    for (int j = 0; j < s.length; j++) plus += Integer.parseInt(s[j]);
                    int i1 = plus * -1;
                    sum += i1;
                } else {
                    int i1 = Integer.parseInt(split[i]) * -1;
                    sum += i1;
                }
            }
        } else {
            String[] split = N.split("\\+");
            for (int i = 0; i < split.length; i++) sum+= Integer.parseInt(split[i]);
        }


        bw.write(sum+"");
        bw.flush();
        br.close();
        bw.close();
    }
}