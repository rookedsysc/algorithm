import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        Map<String, Integer> cache = new HashMap<>();
        int answer = 0;
        
        for(int i = 0; i < cities.length; i++) {
            String city = cities[i].toUpperCase();
            // 캐시에 있는 경우
            if(cache.containsKey(city)) {
                answer += 1;
                cache.put(city, i);
            // 캐시에 없는 경우
            } else {
                answer += 5;
                
                // 캐시가 꽉 찬 경우 기존 캐시 삭제
                if(cache.size() == cacheSize) {
                    String removeKey = "";
                    int min = Integer.MAX_VALUE;
                    for(String key: cache.keySet()) {
                        if(cache.get(key) < min) {
                            min = cache.get(key);
                            removeKey = key;
                        }
                    }
                    cache.remove(removeKey);
                } 
                
                if(cache.size() < cacheSize) {
                	cache.put(city, i);
                }
            }
        }
        return answer;
    }
}