'''
1 + 2 + 4 + 7
5 : 13
6 : 24
7 : 44
8 : 81
9 : 149
10 : 274
'''

n = int(input())
tasks = []
dp = {1: 1, 2: 2, 3: 4, 4: 7}

for _ in range(n):
  tasks.append(int(input()))


def solve(n) :
  if n in dp :
    return dp[n]
  dp[n] = solve(n-1) + solve(n-2) + solve(n-3)
  return dp[n]

for t in tasks :
  print(solve(t))