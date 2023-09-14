import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //4
        //5  3  5 - 3 2-1
        //3  5  3 - 5 2
        //7  5  7 - 5 2-1
        //5  7  5 - 7 2
        // 3 5 5 7
        //6
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int T = Integer.parseInt(br.readLine());
            arr[i] = T;
        }
        for (int i = N-1; i > 0; i--) {
            while (arr[i]<= arr[i-1]){
                sum++;
                arr[i-1] = arr[i-1]-1;
            }
        }
        bw.write(sum + "");
        bw.flush();
        bw.close();
    }
}
