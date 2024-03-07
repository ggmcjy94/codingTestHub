import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int N, K;
    static int[][] tree, dp;
    static int[] arr;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i< N; i++)  arr[i] = Integer.parseInt(st.nextToken());

        int result = 0;
        int eraseCnt = 0;

        //8 2
        //1 2 3 4 5 6 7 8
        
        for (int start = 0, end = 0; start < N; start++) {
            while (end < N) {
                if (arr[end] % 2 == 0) end++;
                else {
                    if (eraseCnt == K) break;
                    eraseCnt++;
                    end++;
                }
            }
            result = Math.max(result, end - start -eraseCnt);
            if (arr[start] % 2 == 1) eraseCnt--;
        }
        bw.write(result+"");

        bw.flush();
        bw.close();
        br.close();
    }

}
