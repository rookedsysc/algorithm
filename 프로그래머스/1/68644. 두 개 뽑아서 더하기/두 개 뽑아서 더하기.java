import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        List<Integer> arr = new ArrayList<Integer>();
        int nlen = numbers.length;
        for(int i = 0; i < nlen - 1; i++) {
            for(int j = i + 1; j < nlen; j ++){
                arr.add(numbers[i] + numbers[j]);
            }
        }
        return arr.stream().sorted().distinct().mapToInt(Integer::intValue).toArray();
    }
}