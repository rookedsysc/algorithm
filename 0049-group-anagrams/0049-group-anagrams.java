import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
      HashMap<String, List<String>> map = new HashMap<>();
      for(String s: strs) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        String key = new String(c);
        List<String> temp = map.getOrDefault(key, new ArrayList<String>());
        temp.add(s);
        map.put(key, temp);
      }
      List<List<String>> answer = new ArrayList<>();
      map.entrySet().stream().forEach(e -> {
        answer.add(e.getValue());
      });
      return answer;
    }
}
