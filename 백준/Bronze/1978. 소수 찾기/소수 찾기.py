n = int(input())
numbers = list(map(int, input().split()))

cnt = len(numbers)

for n in numbers :
  if n == 1 :
    cnt -= 1
    continue
  for v in range(2, n) :
    if n % v == 0 :
      cnt -= 1
      break

print(cnt)