import java.util.*;
import java.math.*;

class Solution {
    private Map<String, Integer> dict = new HashMap<>();
	private int nextKey = 1;

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution("KAKAO")));
    }

    private void init() {
        String[] abc = new String[]{
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
            "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
        };
        for(String s: abc) {
            dict.put(s, nextKey);
            nextKey++;
        }
    }

    public int[] solution(String msg) {
        init();
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < msg.length(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(msg.charAt(i));
            // 최대 문자까지 진행
            for(int j = i + 1; j < msg.length(); j++) {
                sb.append(msg.charAt(j));
                if(!dict.containsKey(sb.toString())) {
                    break;
                }
            }

            // 일치하는 단어가 없다면 새로운 문자 등록
            if(!dict.containsKey(sb.toString())) {
                dict.put(sb.toString(), nextKey);
                nextKey++;

                if(sb.length() > 1) {
                    sb.deleteCharAt(sb.length() - 1);
                    i += sb.length() - 1; // 일치한 단어까지 건너뜀
                }
                result.add(dict.get(sb.toString()));
            }
            // 끝까지 탐색을 했음에도 일치하는 단어가 있다면 종료
            else {
                result.add(dict.get(sb.toString()));
                break;
            }
        }

        int[] ans = new int[result.size()];
        for(int i = 0; i < result.size(); i ++) {
            ans[i] = result.get(i);
        }
		return ans;
    }
}
