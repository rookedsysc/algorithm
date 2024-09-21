import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] DIRECTION = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    static int[][] map, dp;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new int[N][N]; // 메모이제이션 배열 추가

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                max = Math.max(max, dfs(i, j)); // 각 위치에서 dfs 수행
            }
        }

        System.out.println(max);
    }

    public static int dfs(int x, int y) {
        if (dp[x][y] != 0) return dp[x][y]; // 이미 방문한 위치면 저장된 값 반환

        dp[x][y] = 1; // 시작 위치는 무조건 1칸 방문 가능
        for (int[] d : DIRECTION) {
            int nx = x + d[0];
            int ny = y + d[1];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N && map[x][y] < map[nx][ny]) {
                dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1); // 다음 위치 탐색 후 최대 칸 수 갱신
            }
        }

        return dp[x][y];
    }
}