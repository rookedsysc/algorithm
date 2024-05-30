import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int len = progresses.length;
        int[] daysLeft = new int[len];
        ArrayDeque<Integer> answer = new ArrayDeque<>();
        for(int i = 0; i < len; i ++) {
            daysLeft[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
        }
        int count = 0;
        int maxDay = daysLeft[0];
        for(int i = 0; i < len ; i++) {
            if(daysLeft[i] <= maxDay) {
				count++;
            } else {
                answer.addLast(count);
                count = 1;
                maxDay = daysLeft[i];
            }
        }
        answer.addLast(count);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}