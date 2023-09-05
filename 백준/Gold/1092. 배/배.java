import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        List<Integer> nList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            nList.add(Integer.parseInt(st.nextToken()));
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        List<Integer> mList = new ArrayList<>();
        for (int i = 0; i<M; i++) {
            mList.add(Integer.parseInt(st.nextToken()));
        }
        nList.sort(Collections.reverseOrder());
        mList.sort(Collections.reverseOrder());
        //1092
        //3
        //6 8 9
        //5
        //2 5 2 4 7


        if (nList.get(0) < mList.get(0)) {
            System.out.println(-1);
            return;
        }
        int cnt = 0;
        // 9 8 6
        // 7 5 4 2 2
        while (!mList.isEmpty()) {
            int boxIdx = 0, craneIdx = 0;
            while(craneIdx<N){
                if(boxIdx == mList.size())
                    break;
                else if(nList.get(craneIdx) >= mList.get(boxIdx)){
                    mList.remove(boxIdx);
                    craneIdx++;
                }
                else
                    boxIdx++;
            }
            cnt++;
        }
        bw.write(cnt + "");
        bw.flush();
        bw.close();
    }
}