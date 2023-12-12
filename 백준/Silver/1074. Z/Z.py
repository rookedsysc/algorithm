N, r, c = map(int, input().split())

def multiple_2(n):
  ans = 1
  for i in range(n):
    ans *= 2
  return ans

def recursion(n, r, c):
  ans = 0
  if n == 1:
    if [0, 0] == [r, c]:
      return 0
    elif [0, 1] == [r, c]:
      return 1
    elif [1, 0] == [r, c]:
      return 2
    else :
      return 3

  cur_multiple = multiple_2(n - 1)
  # 2 사분면에 있는 경우
  if r < cur_multiple <= c:
    c -= cur_multiple
    ans += cur_multiple * cur_multiple
  # 3 사분면에 있는 경우
  elif c < cur_multiple <= r:
    r -= cur_multiple
    ans += cur_multiple * cur_multiple * 2
  # 4 사분면에 있는 경우
  elif cur_multiple <= c and cur_multiple <= r:
    c -= cur_multiple
    r -= cur_multiple
    ans += cur_multiple * cur_multiple * 3
  ans += recursion(n - 1, r, c)
  return ans


print(recursion(N, r, c))
