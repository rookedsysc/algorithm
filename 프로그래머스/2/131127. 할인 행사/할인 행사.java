import java.util.*;

class Solution {
    	public int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            int cur = map.getOrDefault(discount[i], 0);
            cur++;
            map.put(discount[i], cur);
        }

        int dclen = discount.length;
        int wlen = want.length;
        int cnt = 0;
        for (int i = 0; i < dclen - 9; i++) {
            for (int j = 0; j < wlen; j++) {
                if (map.getOrDefault(want[j], 0) != number[j]) {
                    break;
                }
                if (j == wlen - 1) {
                    cnt ++;
                }
            }
            int cur = map.get(discount[i]);
            cur--;
            map.put(discount[i], cur);
            if(i + 10 < dclen) {
                int temp = map.getOrDefault(discount[i + 10], 0) + 1;
                map.put(discount[i + 10], temp);
            }
        }

        return cnt;
    }

}