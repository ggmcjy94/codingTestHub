import java.io.*;
import java.util.*;

public class Main {

    static int N,M,B;
    static int[][] map;
    static List<Character> mo = Arrays.asList('a','e','i','o','u');

//모음(a,e,i,o,u) 하나를 반드시 포함하여야 한다.
//모음이 3개 혹은 자음이 3개 연속으로 오면 안 된다.
//같은 글자가 연속적으로 두번 오면 안되나, ee 와 oo는 허용한다.
//a
//tv
//ptoui
//bontres
//zoggax
//wiinq
//eep
//houctuh
//end

//<a> is acceptable. <tv> is not acceptable.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (true) {
            String s = br.readLine();
            if (s.equals("end")) break;
            if (!validOne(s)) {
                sb.append("<").append(s).append(">").append(" is not acceptable.\n");
                continue;
            }
            if (!validTwo(s)) {
                sb.append("<").append(s).append(">").append(" is not acceptable.\n");
                continue;
            }
            if (!validThree(s)){
                sb.append("<").append(s).append(">").append(" is not acceptable.\n");
                continue;
            }
            sb.append("<").append(s).append(">").append(" is acceptable.\n");
        }
        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }

    //eepp
    private static boolean validThree(String s) {

        if (s.length() < 2) return true;

        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i)=='e'||s.charAt(i)=='o')continue;
            if (s.charAt(i) == s.charAt(i+1)) {
                return false;
            }
        }
        return true;
    }

    private static boolean validTwo(String s) {
        // 모 3  자 3
        // adeisogu
        if (s.length() < 3) return true;
        for (int i = 0; i < s.length()-2; i++) {
            if (mo.contains(s.charAt(i)) && mo.contains(s.charAt(i+1)) && mo.contains(s.charAt(i+2))) {
                return false;
            }

            if (!mo.contains(s.charAt(i)) && !mo.contains(s.charAt(i+1)) && !mo.contains(s.charAt(i+2))) {
                return false;
            }
        }
        return true;
    }

    private static boolean validOne(String s) {
        for (char c : mo) {
            for (char c1 : s.toCharArray()) {
                if (c == c1) return true;
            }
        }
        return false;
    }
}