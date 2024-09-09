import java.io.*;
import java.util.*;

//5 3
//5 4 3 2 1
//1 3
//2 4
//5 5


//12
//9
//1
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
//5 4 3 2 1
        int[] arr = new int[N+1];
        arr[0] = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i+1] = arr[i] + Integer.parseInt(st.nextToken());
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(arr[b] - arr[a - 1] + "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

}