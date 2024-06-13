import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        HashMap<String, String> ps = new HashMap<>();
        HashMap<String, Integer> useTime = new HashMap<>();

        for (String r : records) {
            String[] temp = r.split(" ");
            String time = temp[0];
            String carN = temp[1];
            String command = temp[2];

            if (command.equals("IN")) {
                ps.put(carN, time);
            } else {
                String start = ps.get(carN);
                Integer use = subtractTime(start, time);
                Integer rest = useTime.getOrDefault(carN, 0);
                ps.remove(carN);
                useTime.put(carN, rest + use);
            }
        }

        ps.forEach((key, value) -> {
            String start = ps.get(key);
            Integer use = subtractTime(start, "23:59");
            Integer rest = useTime.getOrDefault(key, 0);
            useTime.put(key, rest + use);
        });

        int[] ans = useTime.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .map(
                        e -> {
                            int fee = 0;
                            fee += fees[1];
                            int curUse = e.getValue();
                            if (fees[0] < curUse) {
                                curUse -= fees[0];
                                int div = curUse / fees[2];
                                div += curUse % fees[2] == 0 ? 0 : 1;
                                fee += div * fees[3];
                            }
                            return fee;
                        }
                )
                .mapToInt(Integer::intValue)
                .toArray();
        return ans;
    }

    public Integer subtractTime(String start, String end) {
        Integer startH = Integer.parseInt(start.split(":")[0]);
        Integer startM = Integer.parseInt(start.split(":")[1]);
        Integer endH = Integer.parseInt(end.split(":")[0]);
        Integer endM = Integer.parseInt(end.split(":")[1]);

        Integer restM = endM - startM;
        if (restM < 0) { // 만약 시간이 음수가 나올경우
            endH--;
            restM = 60 + restM;
        }

        Integer restH = endH - startH;
        restM += restH * 60;

        return restM;
    }
}