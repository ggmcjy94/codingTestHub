import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.*;

public class Main {

    static int N,Q,M,C,R,T,A,B,X,Y,D;
    static int ans;
    static StringTokenizer st;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] arr;
    static boolean[][] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String al = br.readLine();
        String[] st = new String[]{"c=","c-","dz=","d-","lj","nj","s=","z="};

        for (int i = 0; i < st.length; i++) {
            if (al.contains(st[i])) {
                al = al.replace(st[i], "0");
            }
        }
        bw.write(al.length()+"");
        bw.flush();
        bw.close();
        br.close();

    }

}

