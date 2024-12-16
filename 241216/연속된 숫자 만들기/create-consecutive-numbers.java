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
    static int minVal, maxVal;


    //1
    //2

    
    static void target() {
        int ans = 0;
        while (true) {
            int minA = minCopy[1] - minCopy[0]; // 3
            int minB = minCopy[2] - minCopy[1]; // 2
            int maxA = maxCopy[1] - maxCopy[0]; // 3
            int maxB = maxCopy[2] - maxCopy[1]; // 2
            boolean minCheck = true;
            boolean maxCheck = true;
            int min = Math.min(minA, minB);
            int max = Math.max(maxA, maxB);
            if (minA == 1 && minB==1) {
                minCheck = false;
            }
            if (maxA == 1 && maxB == 1) {
                maxCheck = false;
            }
            if (!minCheck && !maxCheck) {
                break;
            }
            if (minCheck) {
                if (minA == min) {
                    minCopy[2] = minCopy[1];
                    minCopy[1] = (minCopy[1] + minCopy[0]) / 2;
                }
                if (minB == min) {
                    minCopy[0] = minCopy[1];
                    minCopy[1] = (minCopy[2] + minCopy[1]) / 2;
                }
                minVal++;
            }

            if (maxCheck) {
                if (maxA == max) {
                    maxCopy[2] = maxCopy[1];
                    maxCopy[1] = (maxCopy[1] + maxCopy[0]) / 2;
                }
                if (maxB == max) {
                    maxCopy[0] = maxCopy[1];
                    maxCopy[1] = (maxCopy[2] + maxCopy[1]) / 2;
                }
                maxVal++;
            }

        }
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
        target();
        bw.write(minVal+"\n");
        bw.write(maxVal+"");
        bw.flush();
        bw.close();
        br.close();
    }

}