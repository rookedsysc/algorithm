import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] members = {0,0,0};
        int[][] picks = {{1,2,3,4,5}, {2,1,2,3,2,4,2,5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        for(int i = 0; i < answers.length; i ++) {
            if(picks[0][i % 5] == answers[i]) {
                members[0] ++;
            }

            if(picks[1][i % 8] == answers[i]) {
                members[1] ++;
            }

            if(picks[2][i % 10] == answers[i]) {
                members[2] ++;
            }
		}
        int max = Arrays.stream(members).max().getAsInt();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        for(int i = 0; i < members.length; i++) {
            if(members[i] == max) {
                tmp.add(i + 1);
            }
        }
        int[] ans = tmp.stream().mapToInt(Integer::intValue).toArray();

        return ans;
    }
}