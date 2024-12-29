class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] map = new int[rows][columns];
        int cnt = 1;
        int[] ans = new int[queries.length];

        for(int r = 0; r < rows; r ++) {
            for(int c = 0; c < columns; c ++) {
                map[r][c] = cnt;
                cnt++;
            }
        }

        for(int r = 0; r < queries.length; r++) {
            for(int c = 0; c < queries[0].length; c++) {
                queries[r][c] -= 1;
            }
        }

        for(int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int a = Integer.MAX_VALUE;
            int before = map[query[0]][query[1]];
            int temp = Integer.MAX_VALUE;

			// x1 y1(+1) ~ x1 y2
            for(int c = query[1] + 1; c <= query[3]; c++) {
                temp = map[query[0]][c]; // 기존 값 백업
                a = Math.min(a, temp);
                map[query[0]][c] = before; // 이전 값 현재에 넣기
                before = temp; // 백업 했던 기존 값 이전 값으로설정
            }

            // x1(+1) y2 ~ x2 y2
            for(int r = query[0] + 1; r <= query[2]; r++) {
                temp = map[r][query[3]]; // 기존 값 백업
                a = Math.min(a, temp);
                map[r][query[3]] = before; // 이전 값 현재에 넣기
                before = temp; // 백업 했던 기존 값 이전 값으로설정
            }

            // x2 y2(-1) ~ x2 y1
            for(int c = query[3] - 1; c >= query[1]; c--) {
                temp = map[query[2]][c]; // 기존 값 백업
                a = Math.min(a, temp);
                map[query[2]][c] = before; // 이전 값 현재에 넣기
                before = temp; // 백업 했던 기존 값 이전 값으로설정
            }

            // x2(-1) y1 ~ x1 y1
            for(int r = query[2] - 1; r >= query[0]; r--) {
                temp = map[r][query[1]]; // 기존 값 백업
                a = Math.min(a, temp);
                map[r][query[1]] = before; // 이전 값 현재에 넣기
                before = temp; // 백업 했던 기존 값 이전 값으로설정
            }

            ans[i] = a;
        }

        return ans;
    }
}
