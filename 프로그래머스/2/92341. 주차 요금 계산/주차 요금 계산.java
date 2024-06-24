import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        HashMap<String, String> ps = new HashMap<>();
        HashMap<String, Integer> rt = new HashMap<>();
        for(String r : records) {
            String curTime = r.split(" ")[0];
            String carNumber = r.split(" ")[1];
            String op = r.split(" ")[2];
            if(op.equals("IN"))  {
            	ps.put(carNumber, curTime);
			} else {
                String start = ps.get(carNumber);
                ps.remove(carNumber);
                
                Integer diff = calcTime(start, curTime);
                Integer temp = rt.getOrDefault(carNumber, 0);
                rt.put(carNumber, temp + diff);
            }
        }
        
        ps.forEach((carNumber, start) -> {
            Integer usedTime = rt.getOrDefault(carNumber, 0);
            Integer curUseTime = calcTime(start, "23:59");
            rt.put(carNumber, usedTime + curUseTime);
        });
        
        List<Integer> answer = new ArrayList<>();
        
        rt.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(e -> {
            Integer remain = e.getValue();
            Integer fee = 0;
            
            fee += fees[1]; // 기본 요금
            
            remain -= fees[0]; // 기본 시간 빼기 
            if(remain > 0) {
                if(remain % fees[2] != 0) {
                    fee += fees[3];
                }
                Integer div = remain / fees[2];
                fee += div * fees[3];
			}
            answer.add(fee);
        });
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public Integer calcTime(String start, String end) {
        Integer sh = Integer.valueOf(start.split(":")[0]);
        Integer sm = Integer.valueOf(start.split(":")[1]);
        Integer lh = Integer.valueOf(end.split(":")[0]);
        Integer lm = Integer.valueOf(end.split(":")[1]);
        Integer result = 0;
        if(lm - sm < 0) {
            lh --;
            lm += 60;
        }
        result = (lh - sh) * 60 + lm - sm;
        return result;
    }
}