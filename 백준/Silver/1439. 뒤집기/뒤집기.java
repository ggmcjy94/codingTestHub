import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        solution(s);
    }
    private static void solution(String s) throws IOException {
        int oCount = 0;
        int iCount = 0;
//        11001100110011000001
        //11001
        char c = s.charAt(0);
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) != s.charAt(i+1)) {
                if (s.charAt(i) =='1') iCount++;
                if (s.charAt(i) =='0') oCount++;
            }
        }
        if (s.charAt(s.length()-1) == '1') iCount++;
        if (s.charAt(s.length()-1) == '0') oCount++;
        BufferedWriter br = new BufferedWriter(new OutputStreamWriter(System.out));
        int min = Math.min(iCount, oCount);
        br.write(min+"");
        br.flush();
        br.close();
    }
}