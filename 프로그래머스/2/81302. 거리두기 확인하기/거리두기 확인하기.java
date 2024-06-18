import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        Arrays.fill(answer, 1);  // 기본적으로 거리두기를 지키고 있다고 가정

        for (int i = 0; i < places.length; i++) {
            String[] room = places[i];
            if (!checkRoom(room)) {
                answer[i] = 0;
            }
        }

        return answer;
    }

    private boolean checkRoom(String[] room) {
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                if (room[y].charAt(x) == 'P') {
                    // BFS 시작
                    Queue<int[]> queue = new LinkedList<>();
                    boolean[][] visited = new boolean[5][5];
                    queue.offer(new int[] {y, x, 0});  // 좌표와 시작점으로부터의 거리
                    visited[y][x] = true;

                    while (!queue.isEmpty()) {
                        int[] current = queue.poll();
                        int cy = current[0];
                        int cx = current[1];
                        int dist = current[2];

                        if (dist > 0 && dist <= 2 && room[cy].charAt(cx) == 'P') {
                            return false;
                        }

                        if (dist < 2) {
                            for (int[] dir : directions) {
                                int ny = cy + dir[0];
                                int nx = cx + dir[1];
                                if (ny >= 0 && ny < 5 && nx >= 0 && nx < 5 && !visited[ny][nx] && room[ny].charAt(nx) != 'X') {
                                    visited[ny][nx] = true;
                                    queue.offer(new int[] {ny, nx, dist + 1});
                                }
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
