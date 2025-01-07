import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int H;
    static int R;
    static int C;
    // 위 아래 상하 좌 우
    static int[][] D = new int[][]{{1,0,0}, {-1,0,0}, {0,1,0}, {0,-1,0}, {0,0,-1}, {0,0,1}};
    static Deque<int[]> q = new ArrayDeque<>();
    static int[][][] MAP;
    static boolean[][][] visited;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        MAP = new int[H][R][C];
        visited = new boolean[H][R][C];

        for(int h = 0; h < H; h ++) {
            for(int r = 0; r < R; r ++) {
                st = new StringTokenizer(br.readLine());
                for(int c = 0; c < C; c ++) {
                    int value = Integer.parseInt(st.nextToken());
                    MAP[h][r][c] = value;
                    if(value == 1) {
                        q.add(new int[]{h,r,c, 0});
                        visited[h][r][c] = true;
                    }
                }
            }
        }
        int ans = 0;
        while(!q.isEmpty()) {
            int[] p = q.pollFirst();
            int h = p[0], r = p[1], c = p[2], cnt = p[3];
            ans = Math.max(cnt, ans);

            for(int[] d: D) {
                int nh = d[0] + h;
                int nr = d[1] + r;
                int nc = d[2] + c;
                if(nh > -1 && H > nh && nr > -1 && R > nr && nc > -1 && nc < C) {
                    if(!visited[nh][nr][nc] && MAP[nh][nr][nc] == 0) {
                        MAP[nh][nr][nc] = 1;
                        visited[nh][nr][nc] = true;
                        q.add(new int[]{nh,nr,nc, cnt+1});
                    }
                }
            }
        }

        A: for(int h = 0; h < H; h ++) {
            for(int r = 0; r < R; r ++) {
                for(int c = 0; c < C; c ++) {
                    if(MAP[h][r][c] == 0) {
                        ans = -1;
                        break A;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
