import java.util.*;

class Solution {
        public String[] solution(String[] record) {
        HashMap<String, String> map = new HashMap<>();
        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> replacement = new ArrayDeque<>();

        for (String r : record) {
            String[] cmd = r.split(" ");
            if (cmd[0].equals("Enter")) {
                stack.addLast(cmd[1] + "님이 들어왔습니다.");
                map.put(cmd[1], cmd[2]);
                replacement.addLast(cmd[1]);
            } else if (cmd[0].equals("Leave")) {
                stack.addLast(cmd[1] + "님이 나갔습니다.");
                replacement.addLast(cmd[1]);
            } else {
                map.put(cmd[1], cmd[2]);
            }
        }
        String[] result = new String[stack.size()];
        int len = stack.size();
        for (int i = 0; i < len; i++) {
            String temp = stack.pollFirst();
            String replstr = replacement.pollFirst();
            temp = temp.replace(replstr, map.get(replstr));
            result[i] = temp;
        }
        return result;
    }


}