class Solution {
        public int[][] solution(int[][] arr1, int[][] arr2) {
        int Y = arr1.length;
        int X = arr2[0].length;
        int[][] answer = new int[Y][X];
        for(int y = 0; y < Y; y ++) {
            // [0][0] * []
            for(int x = 0; x < X; x ++) {
                for(int k = 0; k < arr2.length; k ++) {
                    answer[y][x] += arr2[k][x] * arr1[y][k];
                }
            }
        }
        return answer;
    }

}