import math

def solution(W, H):
    # 총 격자칸 개수
    total_squares = W * H
    
    # 대각선이 지나가는 격자칸 개수
    diagonal_squares = W + H - math.gcd(W, H)
    
    # 사용할 수 있는 격자칸 개수
    usable_squares = total_squares - diagonal_squares
    
    return usable_squares

# 테스트
print(solution(8, 12))  # 출력: 80