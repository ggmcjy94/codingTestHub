import java.io.*;
        import java.text.SimpleDateFormat;
        import java.util.*;
        import java.util.stream.Collectors;

public class Main {
    static int N, K,R,C;
    static int[][] tree, dp;
    static int[] arr;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int Gr = Integer.parseInt(st.nextToken());
        int Gc = Integer.parseInt(st.nextToken());
        int Pr = Integer.parseInt(st.nextToken());
        int Pc = Integer.parseInt(st.nextToken());
        char[][] arr = new char[R][C];
        for (int i = 0; i< R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = s.charAt(j);
            }
        }
        int PrPC = Pr * Pc;
        int cnt = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j <C; j++) {
                if (arr[i][j] == 'P') {
                    cnt++;
                }
            }
        }

        if (PrPC == cnt) bw.write("0");
        else bw.write("1");
        bw.flush();
        bw.close();
        br.close();
    }

}
