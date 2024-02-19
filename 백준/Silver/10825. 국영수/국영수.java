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

    static class exam implements Comparable<exam>{
        String name;
        int g,e,m;

        public exam(String name, int g, int e, int m) {
            this.name = name;
            this.g = g;
            this.e = e;
            this.m = m;
        }

        @Override
        public int compareTo(exam exam) {
            if (exam.g == this.g && exam.e == this.e && exam.m == this.m) return this.name.compareTo(exam.name);
            if (exam.g == this.g && exam.e == this.e) return exam.m - this.m;
            if (exam.g == this.g) return this.e - exam.e;
            return exam.g - this.g;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        List<exam> exams = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            String name = st.nextToken();
            int g = Integer.parseInt(st.nextToken());
            int e =Integer.parseInt(st.nextToken());
            int m =Integer.parseInt(st.nextToken());
            exams.add(new exam(name, g,e,m));
        }
        Collections.sort(exams);
        for (exam exam : exams) {
            bw.write(exam.name+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
