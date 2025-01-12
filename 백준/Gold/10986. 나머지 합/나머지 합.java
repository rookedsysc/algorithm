import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static long N;
    static long M;
    static long ans = 0;
    static long sum = 0;
    static Map<Long, Long> map = new HashMap<>();

    /**
     * 5랑 2가 있어야 3으로 나눠떨어짐
     * 8 % 3 == 2
     * 5 % 3 == 2
     * 2 % 3 == 2
     * 3 - (5 % 3) = 1, 3 = (5 % 3) + 1
     * 1 3 6 7 9
     */
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            long v = Integer.parseInt(st.nextToken());
            sum += v;
            long rest = sum % M;
            long cnt1 = map.getOrDefault(rest, 0L);

            if (rest == 0) {
                ans++; // 0인 경우 자기 자신 하나 더 추가
            }

            ans += cnt1;
            map.put(rest, cnt1 + 1);
        }
        System.out.println(ans);
    }
}
