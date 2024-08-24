import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int cnt = 0;

    private static List<Integer> primes = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayDeque<Integer> sum = new ArrayDeque<>();

        n = Integer.parseInt(st.nextToken());
        makePrimes();

        for (int i = 0; i < primes.size(); i++) {
            int val = primes.get(i);
            sum.add(0);
            final ArrayDeque<Integer> temp = new ArrayDeque<>();
            while(sum.size() > 0) {
                int cur = sum.poll();
                cur += val;
                if(cur < n) {
                    temp.add(cur);
                } else if(cur == n) {
                    cnt ++;
                }
            }
            sum = new ArrayDeque<>(temp);
        }

        System.out.println(cnt);
    }

    public static void makePrimes() {
        for (int i = 2; i < n + 1; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
    }

    public static Boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
