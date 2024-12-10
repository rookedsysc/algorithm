import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 1번 수열의 길이
 * m idx : 0, length : 3
 * 2번 수열의 길이
 * m idx : 3, length : 4, total length: 7
 * 3번 수열의 길이
 * m idx : 7, length : 4, total length: 7
 * m idx : 10,
 * m idx
 */
public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;

    static int[][] MAP;

    static int blue = 0;
    static int white = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        MAP = new int[N][N];

        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                MAP[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, N, N);

        System.out.println(white);
        System.out.println(blue);
    }

    private static void dfs(int sx, int sy, int mx, int my) {
        int checkResult = check(sx, sy, mx, my);
        if (checkResult == 1) {
            blue++;
            return;
        } else if (checkResult == 0) {
            white++;
            return;
        }
        int halfSize = (mx - sx) / 2;

//        dfs(sx, sy, mx / 2, my / 2);
//        dfs(mx / 2, sy, mx, my / 2);
//        dfs(sx, my / 2, mx / 2, my);
//        dfs(mx / 2, my / 2, mx, my);

        dfs(sx, sy, sx + halfSize, sy + halfSize);
        dfs(sx + halfSize, sy, mx, sy + halfSize);
        dfs(sx, sy + halfSize, sx + halfSize, my);
        dfs(sx + halfSize, sy + halfSize, mx, my);
    }

    /**
     * 파란색 종이면 1, 흰색 종이면
     */
    private static int check(int sx, int sy, int mx, int my) {
        int prev = -1;
        if (sx == mx - 1 && sy == my - 1) {
            return MAP[sx][sy];
        }
        for (int x = sx; x < mx; x++) {
            for (int y = sy; y < my; y++) {
                if (prev == -1) {
                    prev = MAP[x][y];
                } else if (prev != MAP[x][y]) {
                    return -1;
                }
            }
        }
        return prev;
    }
}
