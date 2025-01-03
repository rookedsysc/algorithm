import java.util.*;

class Solution {
    private final Character[] values = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    private final List<String> conditions = new ArrayList<>();
    private int ans = 0;

    public int solution(int n, String[] data) {
        // 조건 초기화
        conditions.addAll(Arrays.asList(data));
        // 순열 탐색 시작
        dfs(new ArrayList<>(), new boolean[8]);
        return ans;
    }

    private void dfs(List<Character> arrangement, boolean[] visited) {
        if (arrangement.size() == 8) {
            // 모든 조건이 만족되면 정답 증가
            if (isValid(arrangement)) {
                ans++;
            }
            return;
        }

        for (int i = 0; i < values.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arrangement.add(values[i]);
                dfs(arrangement, visited);
                arrangement.remove(arrangement.size() - 1);
                visited[i] = false;
            }
        }
    }

    private boolean isValid(List<Character> arrangement) {
        for (String condition : conditions) {
            char p1 = condition.charAt(0);
            char p2 = condition.charAt(2);
            char op = condition.charAt(3);
            int dist = condition.charAt(4) - '0';

            int idx1 = arrangement.indexOf(p1);
            int idx2 = arrangement.indexOf(p2);

            if (idx1 == -1 || idx2 == -1) continue; // 아직 둘 다 배치되지 않은 경우
            int gap = Math.abs(idx1 - idx2) - 1; // 간격 계산

            // 조건에 따라 유효성 검사
            if (op == '=' && gap != dist) return false;
            if (op == '<' && gap >= dist) return false;
            if (op == '>' && gap <= dist) return false;
        }
        return true;
    }
}