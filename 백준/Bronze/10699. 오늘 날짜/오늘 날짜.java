import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.*;

public class Main {

    static int N,Q,M,C,R,T,A,B;
    static int ans;
    static StringTokenizer st;
    static int[] dx = {1,0,-1,0,1,-1,-1,1};
    static int[] dy = {0,1,0,-1,1,1,-1,-1};
    static int[] arr, brr;
    static ArrayList<Integer>[] graph;
    static char[][] map;
    static Queue<int[]> iceQueue;
    static boolean[][] visited;
    static boolean[] visit;
    static int[] dist;
    static StringBuilder sb = new StringBuilder();

    static class GameRoom{
        List<User> users = new ArrayList<>();
    }

    static class User implements Comparable<User>{
        int l;
        char n;

        public User(int l, char n) {
            this.l = l;
            this.n = n;
        }

        @Override
        public int compareTo(User user) {
            return this.n-user.n;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        Date date = new Date();
        DateFormat df = new SimpleDateFormat("YYYY-MM-dd");
        df.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));
        System.out.println(df.format(date));
        bw.flush();
        bw.close();
        br.close();

    }

}

