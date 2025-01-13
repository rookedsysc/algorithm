import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int M;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for(int i = 0; i < N + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int v = Integer.parseInt(st.nextToken());
                if(v == 1) {
                    union(i + 1, j + 1);
                }
            }
        }

        int[] goals = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            goals[i] = Integer.parseInt(st.nextToken());
        }

        boolean flag = false;
        for (int i = 0; i < M - 1; i++) {
            if(find(goals[i + 1]) != find(goals[i])) {
                flag = true;
                break;
            }
        }

        if (flag) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }

    private static boolean union(int x, int y) {
        x = find(x); //x의 부모노드 찾기
        y = find(y); //y의 부모노드 찾기

        // 이미 같은 그래프에 속해있을 때 false 반환
        if (x == y) return false;

        if (x <= y) parent[y] = x;
        else parent[x] = y;
        return true;
    }

    public static int find(int x) {
        if (parent[x] == x) return x;
        return find(parent[x]);
    }
}
