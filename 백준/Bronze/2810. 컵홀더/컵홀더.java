import java.io.*;
import java.util.*;


public class Main {

    static BufferedReader br;
    static BufferedWriter bw;
    static int[][] arr;
    static int[][] arrRes;
    static char[][] str_arr;
    static boolean[][][] visited;
    static int[][] result;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int N,M,K,X,r,g,b,res;
    static int max = Integer.MIN_VALUE;
    static int min_count = 0;
    static int w_cnt,b_cnt,w_res, b_res;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static List<Integer> arr2 = new ArrayList<>();
    static int maxHeight=0;

    //*S*LL*S*
    //4
    //SLLLLSSLL
    //*S*LL*LL*S*S*LL*
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String read = br.readLine();
        int cnt = 0;
        String str = "";
        for (int i = 0; i < N; i++) {
            if (read.charAt(i) == 'S') {  //S (일반석이면) * 추가
                str += "*S";
            } else {
                str += "*LL";  //L (커플석이면) 2칸 넘어간 후 * 추가
                i++;
            }
        }
        str += "*";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '*') cnt++;
        }
        cnt = Math.min(cnt, N);
        bw.write(cnt+"");
        bw.flush();
        bw.close();
    }
}