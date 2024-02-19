import java.io.*;
import java.util.*;

public class Main {
    static int T,N,S,E,M,R,Q,K,min,max;
    static long ans;
    static int[] arr,nums,operator,order;
    static int[] selected,used;
    static int[] dp;
    static int dx[] = {0, -1, 0 ,1};
    static int dy[] = {1, 0, -1, 0};
    static Queue<int[]> queue = new LinkedList<>();
    static ArrayList<Integer>[] con;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    static class Num{
        int bidx, val, aidx;

        public Num(int bidx, int val, int aidx) {
            this.bidx = bidx;
            this.val = val;
            this.aidx = aidx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        List<Num> numList = new ArrayList<>();
        for (int i = 0; i< N; i++) {
            numList.add(new Num(i, Integer.parseInt(st.nextToken()), 0));
        }
        Collections.sort(numList, new Comparator<Num>() {
            @Override
            public int compare(Num num, Num t1) {
                return num.val - t1.val;
            }
        });
        for (int i = 0; i < N; i++) {
            numList.get(i).aidx = i;
        }
        Collections.sort(numList, new Comparator<Num>() {
            @Override
            public int compare(Num num, Num t1) {
                return num.bidx - t1.bidx;
            }
        });

        for (Num num : numList) {
            bw.write(num.aidx + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
