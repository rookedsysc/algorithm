import sys

input = sys.stdin.readline
a = int(input())

x = a // 5
ans = -1

if a == 0 :
  ans = 0
if x * 5 != a :
  while x * 5 != a :
    rest = a - (x * 5)
    if rest % 3 == 0 :
      ans = x + (rest // 3)
      break
    x -= 1
    if x < 0 :
      break
else :
  ans = a // 5

print(ans)

