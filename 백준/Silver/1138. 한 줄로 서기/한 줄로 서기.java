import java.io.*;
import java.util.*;

public class Main {

    static int N,M;


    //N명의 사람들은 매일 아침 한 줄로 선다. 이 사람들은 자리를 마음대로 서지 못하고 오민식의 지시대로 선다.
    //어느 날 사람들은 오민식이 사람들이 줄 서는 위치를 기록해 놓는다는 것을 알았다. 그리고 아침에 자기가 기록해 놓은 것과 사람들이 줄을 선 위치가 맞는지 확인한다.
    //사람들은 자기보다 큰 사람이 왼쪽에 몇 명 있었는지만을 기억한다. N명의 사람이 있고, 사람들의 키는 1부터 N까지 모두 다르다.
    //각 사람들이 기억하는 정보가 주어질 때, 줄을 어떻게 서야 하는지 출력하는 프로그램을 작성하시오.

    //4

    //1 2 3 4

    //4 2 1

    //7
    //6 1 1 1 2 0 0
    //1 2 3 4 5 6 7

    //6 2 3 4 7 5 1

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] ans = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] =Integer.parseInt(st.nextToken());
        }
        //2 1 1 0
        for (int i = 1; i <=N; i++) {
            int j = 1;

            while (true) {
                if (arr[i] == 0 && ans[j] ==0) {
                    ans[j] = i;
                    break;
                } else if (ans[j]==0) { 
                    arr[i]--; // 1 // 0  
                }
                j++; 
            }
        }
        for (int i =1; i<=N; i++) {
            bw.write(ans[i] +" ");
        }
        br.close();
        bw.flush();
        bw.close();
    }


}