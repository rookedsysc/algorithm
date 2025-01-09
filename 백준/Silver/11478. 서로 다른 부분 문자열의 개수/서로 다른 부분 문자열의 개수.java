import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static String str;
    static Set<String> comb = new HashSet<>();

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        str = st.nextToken();

        for(int i = 0; i < str.length(); i ++) {
            StringBuilder sb = new StringBuilder();
            makeComb(sb, i);
        }
        System.out.println(comb.size());
    }

    private static void makeComb(StringBuilder sb, int idx) {
        if(idx >= str.length()) {
            return;
        }
        sb.append(str.charAt(idx));
        comb.add(sb.toString());
        makeComb(new StringBuilder(sb), idx + 1);
    }
}
