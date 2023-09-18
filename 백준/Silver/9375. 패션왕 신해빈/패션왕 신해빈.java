import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            HashMap<String, Integer> map = new HashMap<>();
            int N = Integer.parseInt(br.readLine());

            for (int j = 0; j< N; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                String e = st.nextToken();
                String t = st.nextToken();
                map.put(t , map.getOrDefault(t,0)+1);
            }
            int sum = 1;
            for (Integer value : map.values()) {
                sum *= value+1;
            }
            bw.write(sum-1+"\n");
        }
        //2
        //4
        //hat headgear
        //sunglasses eyewear
        //turban headgear
        //test headgear

        //3
        //mask face
        //sunglasses face
        //makeup face

        //5
        //3

        //첫 번째 테스트 케이스는 headgear에 해당하는 의상이
        // hat, turban이며 eyewear에 해당하는 의상이 sunglasses이므로
        // (hat), (turban), (sunglasses), (hat,sunglasses), (turban,sunglasses)로 총 5가지 이다.
        bw.flush();
        bw.close();
    }
}