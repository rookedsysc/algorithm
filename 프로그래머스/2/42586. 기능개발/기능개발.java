import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> result = new ArrayList<>();
        int cnt = 0; 
        int times = 0;
        int idx = 0;
        int pLen = progresses.length;
        int last = -1;
        while(idx < pLen) {
            times = (100 - progresses[idx]) / speeds[idx]; // 지금 현재의 idx가 100 이상되기 위해서 필요한 시간
            if((100 - progresses[idx]) % speeds[idx] != 0) {
                times ++; // 딱 나눠 떨어지지 않는다면 cnt 1 늘림
            } 
            for(int i = idx; i < pLen; i ++) {
                progresses[i] += speeds[i] * times;
                if(progresses[i] >= 100) {
                    if(last == -1) {
                    	idx = i + 1;
                    	cnt ++;
                    }
				} else {
                    last = i;
                }
            }
            result.add(cnt);
            cnt = 0;
            last = -1;
		}
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}