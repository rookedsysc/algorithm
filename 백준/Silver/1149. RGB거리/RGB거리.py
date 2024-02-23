N = int(input())
houses = []
# 각 집 별 색깔들 비용 리스트에 추가
for _ in range(N):
    houses.append(list(map(int, input().split())))

# 점화식
# i번째 집을 각각의 색으로 칠할때의 가격
# i-1번째 집을 현재색을 제외한 나머지 색으로 칠한 가격중 최소 + 현재 색의 가격
# 3가지 색이므로 i번째마다 3종류의 색을 칠하는 가격을 모두 구한다
dp = [[0]*3 for i in range(N)]

# 첫번째 집은 색깔의 비용 그대로 지불하면 됨
dp[0] = houses[0]

# 3가지 색이므로 3종류의 색 모두 구함
for i in range(1, N):
    # 현재 집의 색깔별 가격은 이전 집의 현재색을 제외한 나머지 색의 최소 + 현재 색의 가격
    dp[i][0] = min(dp[i-1][1], dp[i-1][2]) + houses[i][0]
    dp[i][1] = min(dp[i-1][0], dp[i-1][2]) + houses[i][1]
    dp[i][2] = min(dp[i-1][0], dp[i-1][1]) + houses[i][2]

# N번째까지 모두 칠했을 때의 가격 중 최소값 출력
print(min(dp[-1]))
