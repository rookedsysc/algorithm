import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    //! 위에는 지우면 안됨

    static int R, C, N;
    static char[][] MAP;
    static int[][] D = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        MAP = new char[R][C];

        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            MAP[r] = st.nextToken().toCharArray();
        }

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int cnt = 0;

        while (N > cnt) {
            int target = R - Integer.parseInt(st.nextToken());
            excute(target, cnt);
            cnt++;
        }

        for (char[] chr : MAP) {
            System.out.println(new String(chr));
        }
    }

    private static void excute(int target, int cnt) {
        if (cnt % 2 == 0) {
            for (int c = 0; c < C; c++) {
                if (checkSplitAndChangePosition(target, c)) break;
            }
        } else {
            for (int c = C - 1; c > -1; c--) {
                if (checkSplitAndChangePosition(target, c)) break;
            }
        }
    }

    private static boolean checkSplitAndChangePosition(int target, int c) {
        if (MAP[target][c] == 'x') {
            MAP[target][c] = '.';
            List<int[]> sides = getSide(target, c);
            for (int[] temp : sides) {
                int[] dp = isValidPosition(temp[0], temp[1]);
                if (dp[C] == -1) {
                    changePosition(dp);
                }
            }
            return true;
        } else {
            return false;
        }
    }

    private static void changePosition(int[] highestDepth) {
        int diff = Integer.MAX_VALUE;
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparing(o -> o[0] * -1));
        Deque<int[]> dq = new ArrayDeque<>();
        boolean[][] visited = new boolean[R][C];

        for (int c = 0; c < C; c++) {
            boolean flag = false;

            // 해당 컬럼에는 depth가 정의되지 않은 경우 즉 모든 column이 다 .인 경우
            if (highestDepth[c] == -1) continue;

            // 최초 1개의 값만 추가
            if (dq.isEmpty()) {
                dq.add(new int[]{highestDepth[c], c});
            }

            for (int r = highestDepth[c] + 1; r < R; r++) {
                if (MAP[r][c] == 'x') {
                    diff = Math.min(r - highestDepth[c] - 1, diff);
                    flag = true;
                    break;
                }
            }
            // R까지 탐색 했지만 diff가 없는 경우
            if (!flag) diff = Math.min(R - highestDepth[c] - 1, diff);
            if (diff == 1) break;
        }

        // 현재 클러스터 pq에 저장
        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int r = cur[0];
            int c = cur[1];
            visited[r][c] = true;
            pq.add(new int[]{r, c});

            for (int[] d : D) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                if (MAP[nr][nc] == '.' || visited[nr][nc]) continue;


                highestDepth[nc] = Math.max(highestDepth[nc], nr);
                visited[nr][nc] = true;
                dq.add(new int[]{nr, nc});
            }
        }

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int r = cur[0];
            int c = cur[1];
            while (r > -1 && MAP[r][c] == 'x') {
                int nr = r + diff;
                swap(new int[]{nr, c}, new int[]{r, c});
                r--;
            }
        }
    }

    private static void swap(int[] next, int[] cur) {
        int nr = next[0], nc = next[1], r = cur[0], c = cur[1];
        char temp = MAP[nr][nc];
        MAP[nr][nc] = MAP[r][c];
        MAP[r][c] = temp;
    }

    private static List<int[]> getSide(int r, int c) {
        List<int[]> arr = new ArrayList<>();

        for (int[] d : D) {
            int nr = r + d[0];
            int nc = c + d[1];
            if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
            if (MAP[nr][nc] == '.') continue;
            arr.add(new int[]{nr, nc});
        }
        return arr;
    }

    /**
     * 각 컬럼별 최대 높이 구하고
     * C번째에는 Position이 변경되야 하는지 안해도 되는지를 넣음
     * 1은 포지션 변경 불필요
     * 0은 포지션 변경 필요
     */
    private static int[] isValidPosition(int r, int c) {
        int[] dp = new int[C + 1];
        Arrays.fill(dp, -1);

        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{r, c});

        boolean[][] visited = new boolean[R][C];
        visited[r][c] = true;
        dp[c] = Math.max(dp[c], r);

        while (!q.isEmpty()) {
            int[] cur = q.pollFirst();
            r = cur[0];
            c = cur[1];
            for (int[] d : D) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                if (MAP[nr][nc] == '.' || visited[nr][nc]) continue;

                if (nr == R - 1) dp[C] = 1; // 바닥에 도달한 경우

                dp[nc] = Math.max(dp[nc], nr);
                visited[nr][nc] = true;
                q.add(new int[]{nr, nc});
            }
        }
        return dp;
    }
}