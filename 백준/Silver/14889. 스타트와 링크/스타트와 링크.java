import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int ans = Integer.MAX_VALUE;
    static int N;
    static int[][] power;
    static boolean[] team;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        power = new int[N][N];
        team = new boolean[N]; // true: Team START, false: Team LINK

        for (int r = 0; r < N; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                power[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0); // 첫 번째 사람부터 DFS 탐색 시작
        System.out.println(ans);
    }

    private static void dfs(int depth, int startCount) {
        if (depth == N) {
            if (startCount == N / 2) { // 두 팀이 균등히 나뉘었을 때
                calculateScore();
            }
            return;
        }

        // Team START에 배정
        team[depth] = true;
        dfs(depth + 1, startCount + 1);

        // Team LINK에 배정
        team[depth] = false;
        dfs(depth + 1, startCount);
    }

    private static void calculateScore() {
        int startScore = 0;
        int linkScore = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (team[i] && team[j]) {
                    startScore += power[i][j];
                } else if (!team[i] && !team[j]) {
                    linkScore += power[i][j];
                }
            }
        }

        ans = Math.min(ans, Math.abs(startScore - linkScore));
    }
}
