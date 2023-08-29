import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));
        //문자열의 뒤에 A를 추가한다.
        //문자열을 뒤집고 뒤에 B를 추가한다.
        //B
        //ABBA 1

        String n = br.readLine();
        String s = br.readLine();
        while (true) {
            if (n.length() == s.length()) break;
            char c = s.charAt(s.length() - 1);
            if (c == 'B') {
                s = s.substring(0, s.length()-1);
                StringBuffer sb = new StringBuffer(s);
                s = sb.reverse().toString();
            } else if (c=='A') s = s.substring(0, s.length()-1);
        }
        if (s.equals(n)) bw.write(1+"");
        else bw.write(0+"");
        //AB
        //ABB 0
        bw.flush();
        bw.close();
    }
}
