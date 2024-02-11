'''
1 : 1
2 : 1 + 2 or 2
3 : 1 + 2 or 3
4 : 1 + 2 + 4 or 1 + 3 + 4
5 :
dp[n-2] + time[n] or dp[n - 3] + time[n-1]time[n]
'''

N = int(input())
dp = {}
stairs = []
for _ in range(N) :
  stairs.append(int(input()))
dp[0] = stairs[0]
if N == 1 :
  print(dp[0])
  exit()
dp[1] = stairs[0] + stairs[1]
if N == 2 :
  print(dp[1])
  exit()
dp[2] = max(stairs[0] + stairs[2],stairs[1] + stairs[2])
def recursion(N) :
  global dp, stairs
  if N == 0 or N == 1 or N == 2 :
    return dp[N]
  if N not in dp :
    dp[N] = max(recursion(N - 2) + stairs[N], recursion(N-3) + stairs[N-1] + stairs[N])

  return dp[N]

print(recursion(N - 1))