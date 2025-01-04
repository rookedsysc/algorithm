import java.util.*;

class Solution {

    private final Character[] values = new Character[] {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    private boolean[][] cantVisit = new boolean[8][8];
    private Map<Character, List<Character[]>> rules = new HashMap<>();
    private int ans = 0;

    private void init(String[] data) {
        rules.clear(); // Reset rules
        for (String d : data) {
            char p1 = d.charAt(0);
            char p2 = d.charAt(2);
            char op = d.charAt(3);
            char v = d.charAt(4);

            // 조건 저장
            rules.putIfAbsent(p1, new ArrayList<>());
            rules.putIfAbsent(p2, new ArrayList<>());

            // 양방향 조건 추가
            rules.get(p1).add(new Character[]{p2, op, v});
            rules.get(p2).add(new Character[]{p1, op, v});
        }
    }

    private void dfs(int depth, Set<Character> arranged) {
        if (depth == 8) {
            ans++;
            return;
        }

        for (int i = 0; i < 8; i++) {
            char cur = values[i];
            if (!arranged.contains(cur) && !cantVisit[i][depth]) {
                // 상태 복사
                boolean[][] backup = new boolean[8][8];
                for (int j = 0; j < 8; j++) {
                    backup[j] = cantVisit[j].clone();
                }

                // 조건 적용
                List<Character[]> ruleList = rules.getOrDefault(cur, new ArrayList<>());
                for (Character[] rule : ruleList) {
                    char target = rule[0];
                    char op = rule[1];
                    int v = rule[2] - '0';
                    int targetIdx = Arrays.asList(values).indexOf(target);

                    for (int j = 0; j < 8; j++) {
                        int gap = Math.abs(depth - j) - 1;
                        if (op == '=' && gap != v) cantVisit[targetIdx][j] = true;
                        if (op == '<' && gap >= v) cantVisit[targetIdx][j] = true;
                        if (op == '>' && gap <= v) cantVisit[targetIdx][j] = true;
                    }
                }

                // 다음 깊이로 이동
                arranged.add(cur);
                dfs(depth + 1, arranged);
                arranged.remove(cur);

                // 상태 복원
                cantVisit = backup;
            }
        }
    }

    public int solution(int n, String[] data) {
        init(data);
        dfs(0, new HashSet<>());
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(2, new String[]{"N~F=0", "R~T>2"})); // Expected: 3648
        System.out.println(s.solution(2, new String[]{"M~C<2", "C~M>1"})); // Expected: 0
    }
}