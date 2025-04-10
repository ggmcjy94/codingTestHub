import java.io.*;
import java.util.*;

public class Main {

    static int N,M,T;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        baekjoon online judge
//        <open>tag<close>
        String s = br.readLine();

        StringBuilder ch = new StringBuilder();
        boolean flag = false;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '<') {
                if (!ch.toString().isEmpty()) {
                    for (int j = ch.length()-1; j >= 0; j--) {
                        res.append(ch.charAt(j));
                    }
                    ch = new StringBuilder();
                }
                flag = true;
                res.append('<');
                continue;
            }
            if (c == '>'){
                res.append('>');
                flag = false;
                continue;
            }
            //<ab cd>ef gh<ij kl>
            if (c==' ') {
                if (!flag){
                    for (int j = ch.length()-1; j >= 0; j--) {
                        res.append(ch.charAt(j));
                    }
                    ch = new StringBuilder();
                }
                res.append(c);
                continue;
            }

            if (flag) {
                res.append(c);
            } else {
                ch.append(c);

            }

            if (i == s.length()-1) {
                if (!ch.toString().isEmpty()) {
                    for (int j = ch.length()-1; j >= 0; j--) {
                        res.append(ch.charAt(j));
                    }
                    ch = new StringBuilder();
                }
            }
        }
        bw.write(res.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}