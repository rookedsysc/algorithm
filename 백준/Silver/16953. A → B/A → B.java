import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    //! 위에는 지우면 안됨

    static int A, B;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        Deque<long[]> q = new ArrayDeque<>();
        q.add(new long[]{A, 1});

        while(!q.isEmpty()) {
            long[] cur = q.pollFirst();
            long cv = cur[0], cCnt = cur[1];
            long c1 = cv * 2;
            StringBuilder sb = new StringBuilder();
            sb.append(cv).append("1");
            long c2 = Long.parseLong(sb.toString());

            if(c1 < B) {
                q.add(new long[]{c1, cCnt+1});
            } else if(c1 == B) {
                System.out.println(cCnt + 1);
                return;
            }
            if(c2 < B) {
                q.add(new long[]{c2, cCnt+1});
            } else if(c2 == B) {
                System.out.println(cCnt + 1);
                return;
            }
        }
        System.out.println(-1);
    }
}