import org.omg.CORBA.OMGVMCID;

import java.io.*;
import java.util.*;

public class Main {

    static int N , M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String s = br.readLine();
        String s1 = s.replaceAll("XXXX", "aaaa");
        String s2 = s1.replaceAll("XX", "bb");
        if (s2.contains("X")) {
            bw.write("-1");
        } else {
            bw.write(s2);
        }

        bw.flush();
        bw.close();
        br.close();
    }

}