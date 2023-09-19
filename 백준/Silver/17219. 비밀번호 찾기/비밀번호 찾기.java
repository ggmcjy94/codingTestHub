import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        HashMap<String ,String> map = new HashMap<>();
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for (int i =0; i < N+M; i++) {
            if (i < N) {
                st = new StringTokenizer(br.readLine(), " ");
                String key = st.nextToken();
                String value = st.nextToken();
                map.put(key, value);
            } else {
                String s = br.readLine();
                bw.write(map.get(s)+"\n");
            }
        }
        //16 4
        //noj.am IU
        //startlink.io
        //acmicpc.net
        //noj.am
        //mcc.hanyang.ac.kr
        //acmicpc.net UAENA
        //startlink.io THEKINGOD
        //google.com ZEZE
        //nate.com VOICEMAIL
        //naver.com REDQUEEN
        //daum.net MODERNTIMES
        //utube.com BLACKOUT
        //zum.com LASTFANTASY
        //dreamwiz.com RAINDROP
        //hanyang.ac.kr SOMEDAY
        //dhlottery.co.kr BOO
        //duksoo.hs.kr HAVANA
        //hanyang-u.ms.kr OBLIVIATE
        //yd.es.kr LOVEATTACK
        //mcc.hanyang.ac.kr ADREAMER

        bw.flush();
        bw.close();

    }
}