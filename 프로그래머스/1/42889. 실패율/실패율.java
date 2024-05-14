import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        // 스테이지별 도전자 수를 구함 (N + 1 스테이지(마지막까지 클리어한 사용자)가 들어가기 때문에 + 2를 해줌)
        int[] challenger = new int[N + 2];

        for (int i = 0; i < stages.length; i++) {
            challenger[stages[i]] += 1;
        }

        // 스테이지별 실패한 사용자 수 계산
        HashMap<Integer, Double> failRates = new HashMap<Integer, Double>();
        double total = stages.length;

        for (int i = 1; i <= N; i++) {
            if (challenger[i] == 0) {
                failRates.put(i, (double) 0); // double 입력할 때는 0. 또는 (double) 0
            } else {
                failRates.put(i, challenger[i] / total);
                total -= challenger[i]; // 지금 빠진 도전자들 제외
            }
        }

        return failRates.entrySet()
                .stream()
                .sorted((rate1, rate2) -> Double.compare(rate2.getValue(), rate1.getValue()))
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }
}