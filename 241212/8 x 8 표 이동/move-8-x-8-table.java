import java.util.*;

public class Main {

    // 8방향으로 이동 (상, 하, 좌, 우, 대각선 4방향)
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

    // 8x8 보드
    static char[][] board = new char[8][8];

    // 벽을 한 칸 아래로 내리는 함수
    static void moveWalls() {
        // 맨 아래부터 위로 벽을 내림
        for (int i = 7; i > 0; i--) {
            board[i] = Arrays.copyOf(board[i - 1], 8);
        }
        // 첫 번째 행은 모두 빈 칸으로 설정
        Arrays.fill(board[0], '.');
    }

    // BFS 함수
    static int bfs() {
        // 방문 여부 체크
        boolean[][] visited = new boolean[8][8];
        Queue<int[]> queue = new LinkedList<>();

        // 시작 위치 (7, 0) 추가
        queue.offer(new int[]{7, 0});
        visited[7][0] = true;

        // BFS 탐색
        while (!queue.isEmpty()) {
            int size = queue.size();

            // 큐에서 하나씩 꺼내며 이동
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int x = curr[0];
                int y = curr[1];

                // 목표 지점에 도달하면 1 반환
                if (x == 0 && y == 7) {
                    return 1;
                }

                // 8방향으로 이동
                for (int j = 0; j < 8; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];

                    // 유효한 범위 내에 있고 벽이 아닌 칸을 방문
                    if (nx >= 0 && nx < 8 && ny >= 0 && ny < 8 && !visited[nx][ny] && board[nx][ny] == '.') {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }

            // 한 번의 BFS 탐색이 끝난 후, 벽을 내려야 합니다.
            moveWalls();
        }

        // 목적지에 도달할 수 없다면 0 반환
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 8x8 보드 입력 받기
        for (int i = 0; i < 8; i++) {
            String row = sc.nextLine();
            for (int j = 0; j < 8; j++) {
                board[i][j] = row.charAt(j);
            }
        }

        // BFS 탐색 후 결과 출력
        System.out.println(bfs());
    }
}