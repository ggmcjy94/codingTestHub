import java.io.*;
import java.util.*;
import java.util.function.ToIntFunction;

public class Main {

    static int N,M,B;
    static int[][] map;
    //좌표 (i, j)의 가장 위에 있는 블록을 제거하여 인벤토리에 넣는다.
    //인벤토리에서 블록 하나를 꺼내어 좌표 (i, j)의 가장 위에 있는 블록 위에 놓는다.
    //1번 작업은 2초가 걸리며, 2번 작업은 1초가 걸린다. 밤에는 무서운 몬스터들이 나오기 때문에 최대한 빨리 땅 고르기 작업을 마쳐야 한다.
    //‘땅 고르기’ 작업에 걸리는 최소 시간과 그 경우 땅의 높이를 출력하시오.




    //22 63
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, map[i][j]);
                max = Math.max(max ,map[i][j]);
            }
        }
        int t = Integer.MAX_VALUE;
        int h = 0;
        for (int i = min; i <= max; i++) {
            int cnt = 0;
            int block =B;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k< M; k++) {
                    if (i < map[j][k]) {
                        cnt = cnt + ((map[j][k]-i) * 2);
                        block = block + (map[j][k] - i);
                    } else {
                        cnt = cnt + (i - map[j][k]);
                        block= block- (i-map[j][k]);
                    }
                }
            }
            if (block < 0) break;
            if (t>= cnt) {
                t = cnt;
                h = i;
            }
        }

        bw.write(t +" "+h);
        br.close();
        bw.flush();
        bw.close();
    }
}