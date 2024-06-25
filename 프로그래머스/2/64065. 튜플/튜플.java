import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(1, s.length() - 1);
        String[] tuples = s.split("},");
        Arrays.sort(tuples, (a, b) -> Integer.compare(a.length(), b.length()));
        List<Integer> ans = new ArrayList<>();
        for (String tuple : tuples) {
            String temp = tuple.replace("{", "")
                    .replace("}", "");
            String[] elements = temp.split(",");
            for(String e: elements) {
                int intE = Integer.parseInt(e);
                if(!ans.contains(intE)) {
                    ans.add(intE);
                }
            }
        }

        return ans.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}