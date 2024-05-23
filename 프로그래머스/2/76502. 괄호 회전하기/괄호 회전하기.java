import java.util.*;

class Solution {
        public int solution(String s) {
        int answer = 0;
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');


        int n = s.length();
        s += s;
        A:
        for (int i = 0; i < n; i++) {
            ArrayDeque<Character> stack = new ArrayDeque<>();
            for (int j = i; j < n + i; j++) {
                if (!map.containsKey(s.charAt(j))) {
                    stack.push(s.charAt(j));
                } else {
                    if (stack.isEmpty() || !stack.pop()
                            .equals(map.get(s.charAt(j)))) {
                        continue A;
                    }
                }
            }
            if (stack.isEmpty())
                answer++;
        }
    

        return answer;
    }

}