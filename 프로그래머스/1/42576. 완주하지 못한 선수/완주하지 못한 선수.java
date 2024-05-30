import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        List<String> arr = new ArrayList<>();
        for(String c: completion) {
            int cur = map.getOrDefault(c, 0);
            cur++;
            map.put(c, cur);
        }
        for(String p: participant) {
            if(!map.containsKey(p) || map.get(p) == 0) {
                return p;
            } else {
                int cur = map.get(p);
                cur--;
                map.put(p, cur);
            }
        }
        return "null";
    }
}