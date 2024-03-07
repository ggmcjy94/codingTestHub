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
        int[] arr = new int[N+1];
        int[] temp = new int[N+1];
        int[] pointer = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i<= N; i++) {
            pointer[Integer.parseInt(st.nextToken())] = i;
        }
        // a[1] = 3 , a[2] = 5, a[3] = 1 , a[4] = 4 , a[5] = 2
        // p[4] = 1 , p[3] =2 , p[1] = 3 , p[2] = 4 , p[5]=5
        // t = 1 4 5 3 2 
        for (int i = 0; i<K; i++) {

            for (int j = 1; j <= N; j++) {
                temp[j] = arr[pointer[j]];
            }

            for (int j = 1; j <= N; j++) {
                arr[j] = temp[j];
            }
            
        }
        for (int i = 1; i<=N; i++) bw.write(arr[i]+" ");
        bw.flush();
        bw.close();
        br.close();
    }

}
