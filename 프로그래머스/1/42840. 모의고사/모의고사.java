import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[][] randoms = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        int[] points = new int[3];
        
        for(int i = 0; i < answers.length; i++) {
            if(randoms[0][i % 5] == answers[i]) {
                points[0] ++;
            } 
            if (randoms[1][i % 8] == answers[i]) {
                points[1] ++;
            } 
            if(randoms[2][i % 10] == answers[i]){
                points[2] ++;
            }
        }
        ArrayList<Integer> highScores = new ArrayList<>();
        int max = Arrays.stream(points).max().getAsInt();
        for(int i = 0; i < points.length; i++) {
            if(points[i] == max) {
                highScores.add(i + 1);
            }
        }
        return highScores.stream().mapToInt(Integer::intValue).toArray();
    }
}