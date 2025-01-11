import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int R;
    static int C;
    static char[][] MAP;
    static boolean[][] visited;
    static int turn = -1;
    static int[][] DI = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    static Queue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        MAP = new char[R][C];
        visited = new boolean[R][C];

        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int c = 0; c < C; c++) {
                char cur = str.charAt(c);
                MAP[r][c] = cur;
                if (cur == 'S') {
                    visited[r][c] = true;
                    q.add(new int[]{r,c,0});
                }
            }
        }

        while(!q.isEmpty()) {
            int[] now = q.poll();
            MAP[now[0]][now[1]] = 'D';

            if(now[2] > turn) {
                fillWater();
                turn = now[2];
            }

            for(int[] d: DI) {
                int nr = now[0] + d[0];
                int nc = now[1] + d[1];
                if(-1 < nr && nr < R && -1 < nc && nc <C) {
                    if(MAP[nr][nc] == '.' && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        q.add(new int[]{nr, nc, now[2] + 1});
                    } else if(MAP[nr][nc] == 'D') {
                        ans = Math.min(ans, now[2] + 1);
                        break;
                    }
                }
            }
            MAP[now[0]][now[1]] = '.';
        }
        if(ans == Integer.MAX_VALUE) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(ans);
        }
    }

    private static void fillWater() {
        Deque<int[]> water = new ArrayDeque<>();
        for(int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++) {
                if(MAP[r][c] == '*') water.add(new int[]{r,c});
            }
        }
        while(!water.isEmpty()) {
            int[] w = water.pollFirst();

            for(int[] d: DI) {
                int nr = w[0] + d[0];
                int nc = w[1] + d[1];
                if(-1 < nr && nr < R && -1 < nc && nc <C) {
                    if(MAP[nr][nc] == '.') {
                        MAP[nr][nc] = '*';
                    }
                }
            }
        }
    }
}