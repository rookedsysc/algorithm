
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        // Set 자료형은 비교 메서드를 제공함
        Set<String> ban = new HashSet<String>(Arrays.asList(banned));
        // 정규표현식 \\W는 문자, 숫자, 밑줄(_)을 제외한 모든 문자를 나타낸다. (공백, 구두점도 포함)
        String[] words = paragraph.replaceAll("\\W+", " ")
                .toLowerCase()
                .split(" ");
        Map<String, Integer> counts = new HashMap<>();

        for(String w: words) {
            if(!ban.contains(w)) {
                // 존재하지 않는 단어라면 기본값을 0으로 지정, 또는 추출한 값에 + 1 해서 저장
                counts.put(w, counts.getOrDefault(w, 0) + 1);
            }
        }
        return Collections.max(counts.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}