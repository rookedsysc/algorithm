import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("handshake", "shake hands")); // 결과 예: 65536
    }

    public int solution(String str1, String str2) {
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();

        // 다중집합 생성
        Map<String, Integer> comb1 = makeComb(str1);
        Map<String, Integer> comb2 = makeComb(str2);

        // 교집합 및 합집합 계산
        int inter = 0; // 교집합 크기
        int union = 0; // 합집합 크기

        Set<String> keys = new HashSet<>(comb1.keySet());
        keys.addAll(comb2.keySet()); // 합집합의 모든 키

        for (String key : keys) {
            int count1 = comb1.getOrDefault(key, 0);
            int count2 = comb2.getOrDefault(key, 0);

            inter += Math.min(count1, count2); // 교집합 크기
            union += Math.max(count1, count2); // 합집합 크기
        }

        // 자카드 유사도 계산
        double jaccard = (union == 0) ? 1 : (double) inter / union;
        return (int) (jaccard * 65536);
    }

    private Map<String, Integer> makeComb(String str) {
        Map<String, Integer> result = new HashMap<>();

        for (int i = 0; i < str.length() - 1; i++) {
            char first = str.charAt(i);
            char second = str.charAt(i + 1);

            // 두 글자가 모두 영문자인 경우만 다중집합에 추가
            if (Character.isLetter(first) && Character.isLetter(second)) {
                String key = "" + first + second; // 두 글자 조합
                result.put(key, result.getOrDefault(key, 0) + 1);
            }
        }
        return result;
    }
}