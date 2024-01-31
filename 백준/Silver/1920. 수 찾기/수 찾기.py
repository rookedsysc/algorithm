N = int(input())
A = list(map(int, input().split()))
M = int(input())
arr = list(map(int, input().split()))
A_hash = {}

for a in A :
  A_hash[a] = True

for a in arr :
  if a in A_hash :
    print(1)
  else :
    print(0)

