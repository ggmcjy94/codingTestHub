import java.io.*;
import java.util.*;

public class Main {
    static int T,N,X,C,V,S,E,M,Q,K,R,min,max;
    static int[][] dis, map, arr;
    static int dx[] = {0, -1, 0 ,1};
    static int dy[] = {1, 0, -1, 0};
    static boolean[][] visited,possible;
    static boolean[] visit;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[][] checked;
    static StringBuilder sb = new StringBuilder();
    static int cnt;


    static class CodingTest {
        int problem , level;

        public CodingTest(int problem, int level) {
            this.problem = problem;
            this.level = level;
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        TreeSet<CodingTest> codingTests = new TreeSet<>(new Comparator<>() {
            @Override
            public int compare(CodingTest codingTest, CodingTest t1) {
                if (codingTest.level != t1.level) return codingTest.level - t1.level;
                return codingTest.problem - t1.problem;
            }
        });
        HashMap<Integer, Integer> problems = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            codingTests.add(new CodingTest(p, l));
            problems.put(p, l);
        }


        M = Integer.parseInt(br.readLine());


        for (int i = 0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            String com = st.nextToken();
            if (com.equals("add")) {
                int p = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                codingTests.add(new CodingTest(p, l));
                problems.put(p, l);
            }

            if (com.equals("recommend")) {
                int t = Integer.parseInt(st.nextToken());
                if (t == 1) {
                    sb.append(codingTests.last().problem).append("\n");
                } else {
                    sb.append(codingTests.first().problem).append("\n");
                }
            }
            if (com.equals("solved")){
                int problem = Integer.parseInt(st.nextToken());
                Integer level = problems.get(problem);
                codingTests.remove(new CodingTest(problem, level));
                problems.remove(problem);
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}
