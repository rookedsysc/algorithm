import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int flag = 0;
    private static int N;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static String string;


    public static void main(String[] args) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            flag = 0;
            st = new StringTokenizer(br.readLine());
            string = st.nextToken();
            checkPalindrome(0, string.length() - 1);
            System.out.println(flag);
        }
    }

    private static void checkPalindrome(int forward, int backward) {
        if (forward >= backward) {
            return;
        }

        if (checkCharacterOfIdx(forward, backward)) {
            checkPalindrome(forward + 1, backward - 1);
        } else if (flag == 0) {
            flag++;
            checkPalindrome(forward + 1, backward);

            // 여기서 비교가 끝나면 다음 문자열은 비교 X
            if(flag == 2) flag --;
            else return;
            checkPalindrome(forward, backward - 1);
        } else {
            flag ++;
        }
    }

    private static boolean checkCharacterOfIdx(int forward, int backward) {
        return string.charAt(forward) == string.charAt(backward);
    }
}
