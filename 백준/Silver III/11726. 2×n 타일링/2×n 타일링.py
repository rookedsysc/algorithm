import sys

dp = [0] * 1001 # dp 테이블 초기화
dp[1] = 1 # 1인 경우는 1
dp[2] = 2 # 2인 경우는 2
n = int(sys.stdin.readline())
for i in range(3, n+1):
	# 점화식 표현
    dp[i] = dp[i-2] + dp[i-1]

print(dp[n] % 10007) # 나머지 출력인 점 중요
