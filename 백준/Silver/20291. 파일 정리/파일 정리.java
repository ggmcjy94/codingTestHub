import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int T,N,S,E,M,R,Q,K,min,max;
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

    static int toLeft(int color, int idx) {
        if (idx == 0)
            return Integer.MAX_VALUE;
        return con[color].get(idx) - con[color].get(idx - 1);
    }

    static int toRight(int color, int idx) {
        if (idx + 1 == con[color].size())
            return Integer.MAX_VALUE;
        return con[color].get(idx + 1) - con[color].get(idx);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i<N; i++) {
            st = new StringTokenizer(br.readLine(),".");
            String name = st.nextToken();
            String pack = st.nextToken();
            map.put(pack, map.getOrDefault(pack,0)+1);
        }
        ArrayList<String> arrayList = new ArrayList<>(map.keySet());
        Collections.sort(arrayList, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return s.compareTo(t1);
            }
        });
        for (String s : arrayList) {
            bw.write(s + " " + map.get(s)+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
