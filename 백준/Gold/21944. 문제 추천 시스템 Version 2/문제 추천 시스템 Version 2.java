import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int T,N,X,C,V,S,E,M,Q,K,R,min,max;
    static int[][] dis, map, arr;
    static int dx[] = {0, -1, 0 ,1};
    static int dy[] = {1, 0, -1, 0};
    static boolean[][] visited,possible;
    static boolean[] visit;
//    static ArrayList<ArrayList<Integer>> graph;
    static boolean[][] checked;
    static StringBuilder sb = new StringBuilder();
    static int cnt;
    static int[] dist;
    static int[][] graph;


    static class Pair implements Comparable<Pair> {
        int first, second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Pair pair) {
            if (this.first != pair.first) return this.first - pair.first;
            return this.second - pair.second;
        }
    }

    static TreeSet<Pair> tree;
    static ArrayList<TreeSet<Pair>> treeGroup;
    static HashMap<Integer, Pair> problems;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        tree = new TreeSet<>();
        treeGroup = new ArrayList<>();
        problems = new HashMap<>();

        for (int i = 0; i<= 100; i++) treeGroup.add(new TreeSet<>());

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i< N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            tree.add(new Pair(l, p));
            treeGroup.get(g).add(new Pair(l, p));
            problems.put(p, new Pair(l, g));

        }

        M = Integer.parseInt(br.readLine());


        for (int i = 0; i<M; i++) {
            st=new StringTokenizer(br.readLine());
            String comm = st.nextToken();

            if (comm.equals("add")) {
                int p= Integer.parseInt(st.nextToken());
                int l= Integer.parseInt(st.nextToken());
                int g= Integer.parseInt(st.nextToken());

                tree.add(new Pair(l, p));
                treeGroup.get(g).add(new Pair(l, p));
                problems.put(p, new Pair(l, g));
            }

            if (comm.equals("recommend")) {
                int group = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());

                if (x == -1) {
                    sb.append(treeGroup.get(group).first().second).append("\n");
                } else {
                    sb.append(treeGroup.get(group).last().second).append("\n");
                }
            }

            if (comm.equals("recommend2")) {
                int x = Integer.parseInt(st.nextToken());
                if (x == -1) sb.append(tree.first().second).append("\n");
                else sb.append(tree.last().second).append("\n");
            }

            if (comm.equals("recommend3")) {
                int x = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());
                if (x == -1)  {
                    Pair now = tree.lower(new Pair(l, -1));
                    if (now == null) sb.append("-1").append("\n");
                    else sb.append(now.second).append("\n");
                } else  {
                    Pair now = tree.higher(new Pair(l, -1));
                    if (now == null) sb.append("-1").append("\n");
                    else sb.append(now.second).append("\n");

                }
            }

            if (comm.equals("solved")) {
                int id = Integer.parseInt(st.nextToken());
                Pair pair = problems.get(id);
                treeGroup.get(pair.second).remove(new Pair(pair.first, id));
                tree.remove(new Pair(pair.first, id));
                problems.remove(id);
            }

        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}
