import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int[] MAP;
    static int[] dp;
    static int ans = 0;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        MAP = new int[N];
        dp = new int[N];

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            MAP[n] = Integer.parseInt(st.nextToken());
        }

        /**
         * DP[n]에 올 수 있는 케이스
         * dp[n - 2] + MAP[n]
         * dp[n-1]
         */
        if (N < 2) {
            for (int n = 0; n < N; n++) {
                ans += MAP[n];
            }
        } else {
            dp[0] = MAP[0];
            dp[1] = MAP[0] + MAP[1];
            for (int n = 2; n < N; n++) {
                dp[n] = Math.max(dp[n - 2] + MAP[n], dp[n - 1]);
                int nextValue = MAP[n] + MAP[n - 1];
                if (n > 2) nextValue += dp[n - 3];
                dp[n] = Math.max(nextValue, dp[n]);
            }
            ans = dp[N - 1];
        }
        System.out.println(ans);
    }
}
