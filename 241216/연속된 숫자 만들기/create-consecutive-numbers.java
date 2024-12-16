import java.io.*;
import java.util.*;

public class Main {

    static int N , M, S;
    static char [][] map;
    static int[] arr, maxCopy, minCopy;
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    static List<int[]> wallList = new ArrayList<>();
    static boolean[][] visited;
    


    //1
    //2
    
    static int maxTarget() {
        int ans = 0;
        // 4 7 9
        while (true) {
            int a = maxCopy[1] - maxCopy[0]; // 3
            int b = maxCopy[2] - maxCopy[1]; // 2
            int max = Math.max(a, b);
            if (a == 1 && b==1) break;
            if (a == max) {
                maxCopy[2] = maxCopy[1];
                maxCopy[1] = (maxCopy[1] + maxCopy[0]) / 2;
            }
            if (b == max) {
                maxCopy[0] = maxCopy[1];
                maxCopy[1] = (maxCopy[2] + maxCopy[1]) / 2;
            }
            ans++;
        }
        return ans;
    }
    
    static int minTarget() {
        int ans = 0;
        while (true) {
            int a = minCopy[1] - minCopy[0]; // 3
            int b = minCopy[2] - minCopy[1]; // 2
            int min = Math.min(a, b);
            if (a == 1 && b==1) break;
            if (a == min) {
                minCopy[2] = minCopy[1];
                minCopy[1] = (minCopy[1] + minCopy[0]) / 2;
            }
            if (b == min) {
                minCopy[0] = minCopy[1];
                minCopy[1] = (minCopy[2] + minCopy[1]) / 2;
            }
            ans++;
        }
        return ans;
    }
    
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        minCopy = new int[3];
        maxCopy = new int[3];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            int a  = Integer.parseInt(st.nextToken());
            minCopy[i] = a;
            maxCopy[i] = a;
        }
        int min = minTarget();
        int max = maxTarget();

        bw.write(min+"\n");
        bw.write(max+"");
        bw.flush();
        bw.close();
        br.close();
    }

}