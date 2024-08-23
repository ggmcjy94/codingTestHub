import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = 9;
        int[] arr = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        for (int i = 0; i < N-1; i++) {
            for (int j = i+1; j < N; j++) {
                if (sum - (arr[i] + arr[j]) == 100) {
                    arr[i] =0;
                    arr[j] =0;
                    for (int k = 0; k < N; k++) {
                        if (arr[k] != 0) {
                            bw.write(arr[k]+"\n");
                        }
                    }
                    break;
                }
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}