import java.io.*;
import java.util.*;

public class Main {


    static int N, M, res;
    static int[] vol,tel;
    static int[][] dp, arr;
    static boolean[] visited;

    static class student  implements Comparable<student>{
        int n, i, c;

        public student(int n, int i, int c) {
            this.n = n;
            this.i = i;
            this.c = c;
        }

        @Override
        public int compareTo(student o) {
            int result = this.c - o.c;
            if(result == 0)
                result = this.i - o.i;
            return result;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        List<student> students = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i<= M; i++) {
            int data = Integer.parseInt(st.nextToken());
            boolean flag = false;
            for (int j = 0; j < students.size(); j++) {
                if(students.get(j).n == data){
                    students.get(j).c++;
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                if (students.size() >= N) {
                    Collections.sort(students);
                    students.remove(0);
                }
                students.add(new student(data, i, 1));
            }
        }
        List<Integer> list = new ArrayList<>();
        for (student student : students) {
            list.add(student.n);
        }
        Collections.sort(list);
        for (Integer n : list) {
            bw.write(n +" ");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}