import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int T,N,S,E,M,Q,K,min,max;
    static long ans;
    static int[][] dis;
    static int[] arr,nums,operator,order;
    static int[] selected,used;
    static int[] dp;
    static int dx[] = {0, -1, 0 ,1};
    static int dy[] = {1, 0, -1, 0};
    static Queue<int[]> queue = new LinkedList<>();
    static ArrayList<Integer>[] con;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int[] a = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int x = Integer.parseInt(br.readLine());

        Arrays.sort(a);
        int res = 0;
        for (int i = 1 ; i<= N; i++) {
            int target = x-a[i] , L=1,R=N;
            // 1 2 3 5 7 9 10 11 12
            while (L <= R) {
                int mid =(L+R) / 2;
                if (a[mid] == target) {
                    res+=1;
                    break;
                }
                if (a[mid] < target) { // 12
                    L = mid + 1;
                } else {
                    R = mid - 1;
                }
            }
        }
        bw.write(res/2+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
