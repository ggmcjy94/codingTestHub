import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<String> firstList = new ArrayList<>();
        List<String> secondList = new ArrayList<>();
        for (int i =0; i<N+M; i++) {
            if (i < N) {
                firstList.add(br.readLine());
            } else {
                secondList.add(br.readLine());
            }
        }
        int cnt = 0;
        for (String s : secondList) {
            if (firstList.contains(s)) {
                cnt++;
            }
        }
        bw.write(cnt+ "");
        //5 11
        //baekjoononlinejudge
        //startlink
        //codeplus
        //sundaycoding
        //codingsh

        //baekjoon
        //codeplus
        //codeminus
        //startlink
        //starlink
        //sundaycoding
        //codingsh
        //codinghs
        //sondaycoding
        //startrink
        //icerink

        //4



        bw.flush();
        bw.close();

    }
}
