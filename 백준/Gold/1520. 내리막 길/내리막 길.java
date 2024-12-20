import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int M, N, answer;
    static int[][] map, dp; // dp 배열에 "x, y에서 M - 1, N - 1까지 이동하는 경로의 수" 를 저장
    static int[] dx = { -1, 0, 1,  0 };
    static int[] dy = {  0, 1, 0, -1 };

    static int DFS(int x, int y) {
        if (x == M - 1 && y == N - 1) { // 도착 지점까지 도달했을 경우
            return 1;
        }
        if (dp[x][y] != -1) return dp[x][y]; // 방문했다면 저장된 값을 리턴 => 시간을 단축

        // 방문 안 했다면
        dp[x][y] = 0; // 먼저 0으로 세팅
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextX > M - 1 || nextY < 0 || nextY > N - 1) continue;
            // map[nextX][nextY]에서 끝점까지 도달하는 경로의 개수를 더한다
            if (map[x][y] > map[nextX][nextY]) {
                dp[x][y] += DFS(nextX, nextY);
            }
        }

        return dp[x][y];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        dp = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1; // -1은 아직 방문 전, 방문한 곳은 0 이상으로 표시
            }
        }

        answer = DFS(0, 0);
        System.out.println(answer);
    }
}
