import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int X;
    static int max;
    static int cnt = 0;
    static int[] psum;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        psum = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        int sum = 0;
        for(int i = 1; i < N + 1; i ++) {
            int v = Integer.parseInt(st.nextToken());
            sum += v;
            psum[i] = sum;
        }

        for(int i = 1; i < N - X + 2; i ++) {
            int premax = max;
            int cur = psum[i + X - 1] - psum[i - 1];
            if(premax < cur) {
                max = cur;
                cnt = 1;
            } else if(premax == cur) {
                cnt ++;
            }
        }

        if(max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(cnt);
        }
    }
}