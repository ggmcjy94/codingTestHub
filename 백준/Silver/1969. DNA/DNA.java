import java.io.*;
import java.util.*;

public class Main {

    static class DNA {
        char d;
        int c;

        public DNA(char d, int c) {
            this.d = d;
            this.c = c;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // 1969
        // 5 8
        char[][] arr = new char[m][n];
        for (int i =0; i < n; i++) {
            String text = br.readLine();
            for (int j = 0; j<m;j++) {
                arr[j][i] = text.charAt(j);
            }
        }
        String result = "";
        int cnt = 0;
        for (int i=0; i < m; i++) {
            Map<Character, Integer> map = new TreeMap<>();
            for (int j=0; j < n; j++) {
                map.put(arr[i][j] , map.getOrDefault(arr[i][j],0)+1);
            }
            List<Character> keySet = new ArrayList<>(map.keySet());
            keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));
            Character character = keySet.get(0);
            result += keySet.get(0);
            for (Character key : keySet) {
                if(character != key) cnt += map.get(key);
            }
        }
        bw.write(result+"\n");
        bw.write(cnt+"");
        bw.flush();
        bw.close();
    }
}

