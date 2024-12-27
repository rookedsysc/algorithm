import java.math.BigInteger;

class Solution {
    public long solution(int W, int H) {
        // 최대공약수 계산
        int gcd = BigInteger.valueOf(W).gcd(BigInteger.valueOf(H)).intValue();

        // 총 격자 칸 수
        long totalSquares = (long) W * H;

        // 대각선이 지나가는 격자 칸 수
        long diagonalSquares = (long) W + H - gcd;

        // 사용할 수 있는 격자 칸 수
        return totalSquares - diagonalSquares;
    }
}