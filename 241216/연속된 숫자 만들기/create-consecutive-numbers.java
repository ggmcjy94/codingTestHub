import java.io.*;
import java.util.*;

public class Main {

    static int N , M, S;
    static char [][] map;
    static int[] arr, maxCopy, minCopy;
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    static List<int[]> wallList = new ArrayList<>();
    static boolean[][] visited;
    static int minVal, maxVal;


    //1
    //2

    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int[] arr = new int[3];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int a = arr[0];
        int b = arr[1];
        int c = arr[2];

        if (b-a == 1 && c-a == 1) {
            bw.write(0+ "\n" + 0);
        }
        int min;
        int max;
        if (c - b == 2 || b - a == 2) {
            min = 1;
        } else {
            min = 2;
        }
        max = Math.max(c - b, b - a) - 1;
        bw.write(min + "\n" + max);
        bw.flush();
        bw.close();
        br.close();
    }

}