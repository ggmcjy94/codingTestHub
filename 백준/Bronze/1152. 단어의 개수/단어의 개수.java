import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//The Curious Case of Benjamin Button

        String str = br.readLine();
        int cnt = 0;
        StringBuilder ddd = new StringBuilder();


        for (int i = 0;  i < str.length(); i++) {
            if (Character.isAlphabetic(str.charAt(i))) {
                ddd.append(str.charAt(i));
            }
            if (str.charAt(i) == ' ' || i == str.length()-1) {
                if (ddd.length() > 0) {
                    cnt++;
                    ddd = new StringBuilder();
                }
            }
        }

        bw.write(cnt+"");
        br.close();
        bw.flush();
        bw.close();

    }

}