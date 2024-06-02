import java.util.*;

class Solution {
        public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, Integer> replaceToIdx = new HashMap<>();
        HashMap<Integer, Set<Integer>> replied = new HashMap<>();
        int[] answer = new int[id_list.length];

        for (int i = 0; i < id_list.length; i++) {
            String id = id_list[i];
            replaceToIdx.put(id, i);
        }
        for (String r : report) {
            String[] temp = r.split(" ");
            int to = replaceToIdx.get(temp[0]);
            int from = replaceToIdx.get(temp[1]);
            Set<Integer> curReply = replied.getOrDefault(from, new HashSet<>());
            curReply.add(to);
            replied.put(from, curReply);
        }
        replied.entrySet()
                .stream()
                .filter(entry -> {
                    int size = replied.get(entry.getKey()).size();
                    return size >= k;
                })
                .forEach(
                        e -> {
                            replied.get(e.getKey())
                                    .forEach(
                                            idx -> {
                                                answer[idx]++;
                                            }
                                    );
                        }
                );

        return answer;
    }

}