import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int M;
    static int[][] psum;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        psum = new int[N + 1][N + 1];

        for (int r = 1; r < N + 1; r++) {
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            for (int c = 1; c < N + 1; c++) {
                int v = Integer.parseInt(st.nextToken());
                sum += v;
                psum[r][c] += sum;
            }
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int v = 0;
            for(int x = x1; x < x2 + 1; x++) {
                v = v - psum[x][y1 - 1] + psum[x][y2];
            }
            System.out.println(v);
        }
    }
}