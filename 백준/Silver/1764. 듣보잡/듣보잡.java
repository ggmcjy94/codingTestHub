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
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        String[] A = new String[N+1];
        String[] B = new String[M+1];
        for (int i = 1; i <= N; i++) A[i] = br.readLine();
        for (int i = 1; i <= M; i++) B[i] = br.readLine();
        //ohhenrie
        //charlie
        //baesangwook

        //obama
        //baesangwook
        //ohhenrie
        //clinton

        Arrays.sort(A, 1, N+1);
        List<String> list = new ArrayList<>();
        int res = 0;
        for (int i = 1; i <= M; i++) {
            int L=1, R = N;
            while (L <= R) {
                int mid = (L + R) / 2;
                if (A[mid].equals(B[i])) {
                    res++;
                    list.add(B[i]);
                }
                if (A[mid].compareTo(B[i]) < 0) {
                    L = mid + 1;
                } else {
                    R = mid - 1;
                }
            }
        }

        bw.write(res + "\n");
        Collections.sort(list);
        for (String s : list) {
            bw.write(s+"\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }
}
