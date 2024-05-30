import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        ArrayDeque<String> q1 = new ArrayDeque<>(Arrays.asList(cards1));
        ArrayDeque<String> q2 = new ArrayDeque<>(Arrays.asList(cards2));
        
        for(int i = 0; i < goal.length ; i++) {
            if(!q1.isEmpty() && q1.peekFirst().equals(goal[i])) {
                q1.pollFirst();
            } else if(!q2.isEmpty() && q2.peekFirst().equals(goal[i])) {
                q2.pollFirst();
            } else {
                answer = "No";
                break;
            }
            
        }
        
        return answer;
    }
}