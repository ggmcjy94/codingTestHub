import java.io.*;
import java.util.*;

public class Main {

    static int N,M,C,R,T,A,B;
    static int ans;
    static StringTokenizer st;
    static int[] dx = {1,0,-1,0,1,-1,-1,1};
    static int[] dy = {0,1,0,-1,1,1,-1,-1};
    static int[][] arr, brr;
    static ArrayList<Integer>[] graph;
    static char[][] map;
    static Queue<int[]> iceQueue;
    static boolean[][] visited;
    static boolean[] visit;
    static int[] dist;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String val = br.readLine();

        arr=new int[val.length()+1][26];
        for (int i = 1; i <= val.length(); i++) {
            for (int j = 0; j < 26; j++) {
                arr[i][j] = arr[i-1][j];
            }
            arr[i][val.charAt(i-1) - 'a'] += 1;
        }
        N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int tar = st.nextToken().charAt(0) -'a';
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            bw.write(arr[end+1][tar] - arr[start][tar] +"\n");
        }

        bw.flush();
        bw.close();
        br.close();

    }

}

