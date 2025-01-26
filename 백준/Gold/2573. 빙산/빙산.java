import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    //! 위에는 지우면 안됨

    static int R;
    static int C;
    static Integer[][] MAP;
    static Deque<int[]> q = new ArrayDeque<>();
    static int ans = 0;
    static int[][] D = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        MAP = new Integer[R][C];

        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                int v = Integer.parseInt(st.nextToken());
                MAP[r][c] = v;
                if (v > 0) {
                    q.addFirst(new int[]{r, c});
                }
            }
        }

        while (!isDivide()) {
            ans++;

            Integer[][] temp = new Integer[R][C];
            for (int i = 0; i < R; i++) {
                temp[i] = MAP[i].clone();
            }

            Deque<int[]> tq = new ArrayDeque<>();
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];
                for (int[] d : D) {
                    int nr = r + d[0];
                    int nc = c + d[1];
                    if (!(nr > -1 && nr < R && nc > -1 && nc < C)) continue;
                    if (MAP[nr][nc] == 0 && temp[r][c] > 0) {
                        temp[cur[0]][cur[1]] -= 1;
                    }
                }

                // 아직 빙산이면
                if (temp[r][c] > 0) {
                    tq.add(new int[]{r, c});
                }
            }
            MAP = temp;
            q = new ArrayDeque<>(tq);
        }
        System.out.println(ans);
    }

    private static boolean isDivide() {
        // 다 빌 때까지 분리가 안된 경우
        if (q.isEmpty()) {
            ans = 0;
            return true;
        }

        // 방문 여부를 저장하는 배열
        boolean[][] visited = new boolean[R][C];
        // BFS 탐색을 위한 큐
        Deque<int[]> temp = new ArrayDeque<>();

        // 첫 번째 빙산 덩어리의 시작점
        int[] first = q.peekFirst();
        temp.add(first);
        visited[first[0]][first[1]] = true;

        int cnt = 0; // 연결된 빙산 덩어리의 크기

        // BFS 탐색
        while (!temp.isEmpty()) {
            int[] cur = temp.poll();
            cnt++;
            for (int[] d : D) {
                int nr = cur[0] + d[0];
                int nc = cur[1] + d[1];
                if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visited[nr][nc] && MAP[nr][nc] > 0) {
                    visited[nr][nc] = true;
                    temp.add(new int[]{nr, nc});
                }
            }
        }

        // 전체 빙산 덩어리의 크기와 비교하여 분리 여부 확인
        if (cnt < q.size()) {
            return true; // 분리됨
        }
        return false; // 분리되지 않음
    }
}