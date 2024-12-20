import org.omg.CORBA.OMGVMCID;

import java.io.*;
import java.util.*;

public class Main {

    static int N , M;

    static class Developer {
        int pos, tar;

        public Developer(int pos, int tar) {
            this.pos = pos;
            this.tar = tar;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        List<Developer> developers0 = new ArrayList<>();
        List<Developer> developers1 = new ArrayList<>();
        boolean no = false;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            if (t == 0) {
                no = true;
                developers0.add(new Developer(p, t));
            } else {
                developers1.add(new Developer(p, t));
            }
        }
        int ans = Integer.MAX_VALUE;
        if (no) {
            
            for (Developer developer0 : developers0) {
                for (Developer developer1 : developers1) {
                    ans = Math.min(ans, Math.abs(developer1.pos - developer0.pos));
                }
            }
            ans = ans - 1 ;    
        } else {
            ans = 0;
        }
        
        int cnt = 1;
        Collections.sort(developers1, Comparator.comparingInt(o -> o.pos));
        for (int i = 0; i < developers1.size()-1; i++) {
            if (Math.abs(developers1.get(i+1).pos - developers1.get(i).pos) <= ans) continue;
            cnt++;
        }

        //R = 2
        //1 1
        //3 1
        //6 1
        //7 1
        //15 1


        bw.write(cnt+"");
        bw.flush();
        bw.close();
        br.close();
    }

}