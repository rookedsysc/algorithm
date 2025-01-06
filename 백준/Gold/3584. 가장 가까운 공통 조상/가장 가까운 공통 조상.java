import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int T;

    static int[] parents;
    static Set<Integer> visit;
    static int ans;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        for(int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            ans = 10001;
            N = Integer.parseInt(st.nextToken());
            visit = new HashSet<>();
            parents = new int[N  + 1];
            Arrays.fill(parents, -1);

            for(int i = 0; i < N - 1; i++) {
                st = new StringTokenizer(br.readLine());
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());
                parents[child] = parent;
            }

            st = new StringTokenizer(br.readLine());
            int c1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            dfs(c1);
            dfs(c2);
            System.out.println(ans);
        }
    }

    private static void dfs(int child) {
        if(parents[child] == -1) {
            ans = child;
            return;
        }
        // 최초 동시 부모(?)
        if(visit.contains(child)) {
            ans = child;
            return;
        }

        visit.add(child);
        dfs(parents[child]);
    }
}