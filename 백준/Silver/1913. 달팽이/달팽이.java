import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int G;
    static int[][] MAP;
    static int[] ans;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        G = Integer.parseInt(st.nextToken());
        MAP = new int[N][N];

        int c = N / 2;
        int cnt = 1;
        // 가장 안쪽부터 시작
        for (int i = N / 2; i > -1; i--) {
            int r = i;
            // 오른쪽으로 진행
            for (c = c; c < N - i; c++) {
                cnt = recordToMap(r, c, cnt);
            }
            c--;
            for (r = i; r < N - i; r++) {
                cnt = recordToMap(r, c, cnt);
            }
            r--;
            for (c = c; c >= i; c--) {
                cnt = recordToMap(r, c, cnt);
            }
            c++;
            for (r = N - i - 1; r >= i; r--) {
                cnt = recordToMap(r, c, cnt);
            }

        }

        for (int[] row : MAP) {
            StringBuilder sb = new StringBuilder();
            for (int col : row) {
                sb.append(col).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb);
        }

        StringBuilder sb = new StringBuilder();
        for (int col : ans) {
            sb.append(col).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    private static int recordToMap(int r, int c, int cnt) {
        if (MAP[r][c] == 0) {
            MAP[r][c] = cnt;
            if (cnt == G) {
                ans = new int[]{r + 1, c + 1};
            }
            cnt++;
        }
        return cnt;
    }
}