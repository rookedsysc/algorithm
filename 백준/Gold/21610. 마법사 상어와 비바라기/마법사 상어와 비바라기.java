import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int M, N;
    static int[][] MAP;
    static int[][] D = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
    static boolean[][] visited;
    static Deque<int[]> grooms = new ArrayDeque<>();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        MAP = new int[M][M];

        // 초기 구름 위치 설정
        grooms.addLast(new int[]{M - 1, 0});
        grooms.addLast(new int[]{M - 1, 1});
        grooms.addLast(new int[]{M - 2, 0});
        grooms.addLast(new int[]{M - 2, 1});

        for (int r = 0; r < M; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                MAP[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            grooms = moveGroom(); // 구름 이동 후 새로운 위치 반환
            copyBug(new ArrayDeque<>(grooms)); // 물 복사 버그 수행
            minusWater(); // 물 2 이상인 칸 처리 후 새로운 구름 생성
        }

        int sum = 0;
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < M; c++) {
                sum += MAP[r][c];
            }
        }
        System.out.println(sum);
    }

    private static Deque<int[]> moveGroom() throws Exception {
        st = new StringTokenizer(br.readLine());
        int di = Integer.parseInt(st.nextToken()) - 1;
        int si = Integer.parseInt(st.nextToken());

        Deque<int[]> newGrooms = new ArrayDeque<>();
        visited = new boolean[M][M]; // 방문 배열 초기화

        while (!grooms.isEmpty()) {
            int[] cur = grooms.pollFirst();
            int nr = (cur[0] + D[di][0] * si) % M;
            int nc = (cur[1] + D[di][1] * si) % M;

            // 음수 좌표를 양수로 변환 (좌표를 원형으로 처리)
            if (nr < 0) nr += M;
            if (nc < 0) nc += M;

            MAP[nr][nc]++; // 물 증가
            visited[nr][nc] = true;
            newGrooms.addLast(new int[]{nr, nc});
        }

        return newGrooms; // 이동한 구름 위치 반환
    }

    private static void copyBug(Deque<int[]> q) {
        while (!q.isEmpty()) {
            int[] cur = q.pollFirst();
            int r = cur[0], c = cur[1];
            for (int i = 1; i < 8; i += 2) { // 대각선 방향
                int nr = r + D[i][0];
                int nc = c + D[i][1];
                if (nr >= 0 && nr < M && nc >= 0 && nc < M && MAP[nr][nc] > 0) {
                    MAP[r][c]++;
                }
            }
        }
    }

    private static void minusWater() {
        Deque<int[]> newGrooms = new ArrayDeque<>();

        for (int r = 0; r < M; r++) {
            for (int c = 0; c < M; c++) {
                if (!visited[r][c] && MAP[r][c] >= 2) { // 이전 구름 위치가 아니면서 물이 2 이상
                    newGrooms.addLast(new int[]{r, c});
                    MAP[r][c] -= 2;
                }
            }
        }

        grooms = newGrooms; // 새로운 구름 업데이트
    }
}