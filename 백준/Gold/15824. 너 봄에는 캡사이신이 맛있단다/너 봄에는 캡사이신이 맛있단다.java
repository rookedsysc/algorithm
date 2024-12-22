import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static final long MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] foods = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            foods[i] = Integer.parseInt(st.nextToken());
        }

        // 스코빌 지수 정렬
        Arrays.sort(foods);

        // 2^i 계산을 위한 배열
        long[] powerOfTwo = new long[N];
        powerOfTwo[0] = 1;
        for (int i = 1; i < N; i++) {
            powerOfTwo[i] = (powerOfTwo[i - 1] * 2) % MOD;
        }

        long result = 0;
        for (int i = 0; i < N; i++) {
            // foods[i]가 최댓값으로 기여하는 경우
            long maxContribution = (foods[i] * powerOfTwo[i]) % MOD;
            // foods[i]가 최솟값으로 기여하는 경우
            long minContribution = (foods[i] * powerOfTwo[N - i - 1]) % MOD;
            // 최댓값 - 최솟값 기여
            result = (result + maxContribution - minContribution + MOD) % MOD;
        }

        System.out.println(result);
    }
}