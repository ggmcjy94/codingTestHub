import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Person {
        int i , p, k,s;

        public Person(int i, int p, int k, int s) {
            this.i = i;
            this.p = p;
            this.k = k;
            this.s = s;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int L = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        List<Person> personList = new ArrayList<>();


        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int s = k - p;
            personList.add(new Person(i, p, k ,s));
        }

        int targetA = 0;
        int max = Integer.MIN_VALUE;
        for (Person person : personList) {
            if (max < person.s) {
                max = person.s;
                targetA = person.i;
            }
        }

        int targetB = 0;
        boolean[][] cakes = new boolean[L+1][L+1];
        for (int i = 1; i <= L; i++) {
            cakes[i][i] = true;
        }

        for (Person person : personList) {
            int cnt = 0;
            for (int i = person.p; i <= person.k; i++) {
                if (cakes[i][i]) {
                    cakes[i][i] = false;
                    cnt++;
                }
            }
            person.s = cnt;
        }

        int max2 = Integer.MIN_VALUE;
        for (Person person : personList) {
            if (max2 < person.s) {
                max2 = person.s;
                targetB = person.i;
            }
        }

        bw.write(targetA+"\n");
        bw.write(targetB+"\n");
        br.close();
        bw.flush();
        bw.close();
    }
}