class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int Y = arr1.length;
        int X = arr2[0].length;
        int[][] ans = new int[Y][X];
        
        for(int y = 0; y < Y; y++) {
            for(int x = 0; x < X; x ++) {
                for(int k = 0; k < arr1[0].length; k++) {
                    ans[y][x] += arr1[y][k] * arr2[k][x];
                }
            }
        }
            
        return ans;
    }
}