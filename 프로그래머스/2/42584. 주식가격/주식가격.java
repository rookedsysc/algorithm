import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        for(int i = 0; i < n; i++) {
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int cur = stack.pop();
                answer[cur] = i - cur;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            int cur = stack.pop();
            answer[cur] = n - cur - 1;
		}
        
        return answer;
    }
}