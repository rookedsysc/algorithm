import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        char[] charList = s.toCharArray();
        ArrayDeque<Character> stack = new ArrayDeque<Character>();
        for(int i = 0; i < charList.length ; i++) {
            // 안에 현재 값이 이미 들어있는 경우 
            if(!stack.isEmpty() && stack.peek().equals(charList[i])) {
                stack.pop();
            } else {
                stack.push(charList[i]);
            }
        }
        if(stack.isEmpty()) {
            answer ++;
        }
        
        return answer;
    }
}