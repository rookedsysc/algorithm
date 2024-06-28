import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = s.length();
 
        // 문자열의 반절 이상은 압축하는 의미가 없다.
        for (int i = 1; i <= s.length() / 2; i++) {
            String a = compress(s, i);
 
            answer = Math.min(answer, a.length());
        }
 
        return answer;
    }
 
    private String compress(String s, int num) {
        int count = 1;
 
        String pattern = s.substring(0, num);
 
        StringBuilder builder = new StringBuilder();
 
        for (int i = num; i < s.length(); i += num) {
            // 비교 인덱스가 s의 길이보다 길어질 경우
            if (i + num > s.length()) {
                // 애초에 압축이 불가능하므로 넘어감
 
                builder.append(s.substring(i));
            }
 
            // 아닐 경우
            else {
                String target = s.substring(i, i + num);
 
                // 문자열과 패턴이 동일할 경우
                if (target.equals(pattern)) {
                    count++;
                }
 
                // 동일하지 않을 경우
                else {
                    // 2회 이상 압축이 가능할 경우
                    if (count > 1) {
                        builder.append(count);
 
                        count = 1;
                    }
 
                    builder.append(pattern);
 
                    // 패턴 갱신
                    pattern = target;
                }
            }
        }
 
        // 2회 이상 압축이 가능할 경우
        if (count > 1) {
            builder.append(count);
        }
 
        builder.append(pattern);
 
        return builder.toString();
    }
}