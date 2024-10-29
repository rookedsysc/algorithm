import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static int N; // 초밥 접시 수
    static int d; // 초밥 가짓수
    static int k; // 연속해서 먹는 접시의 수
    static int c; // 쿠폰 번호
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] map;
    static HashMap<Integer, Integer> hash = new HashMap<>();
    static int cnt = 0;
    static int plateCnt = 0;
    static int max = 0;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int tmp = Integer.parseInt(st.nextToken());
            map[i] = tmp;

            calculatePlate(tmp, i);
        }

        for (int i = 0; i < k; i++) {
            calculatePlate(map[i], i);
        }

        System.out.println(max);
    }

    private static void calculatePlate(int tmp, int i) {
        // 접시가 다 찬 경우
        if (k == cnt) {
            addPlate(tmp);
            subPlate(i - k);
            if (!hash.containsKey(c)) {
                hash.put(c, 1);
                plateCnt++;
            }
        } else {
            cnt++;
            addPlate(tmp);
        }

        max = Math.max(max, plateCnt);
    }

    public static void addPlate(int p) {
        // 접시가 이미 있었던 경우
        if (hash.containsKey(p)) {
            int cnt = hash.get(p);
            cnt++;
            hash.put(p, cnt);
        } else {
            hash.put(p, 1);
            plateCnt++;
        }
    }

    public static void subPlate(int idx) {
        if(idx < 0) {
            idx = N + idx;
        }
        int pv = map[idx]; // 해당 인덱스에 있는 초밥

        if (hash.containsKey(pv)) {
            int cnt = hash.get(pv);
            cnt--;
            if (cnt == 0) {
                plateCnt--;
                hash.remove(pv);
            } else {
                hash.put(pv, cnt);
            }
        }
    }
}
