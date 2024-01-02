n = int(input())

for _ in range(n) :
  vps = list(str(input()))
  stack = []
  ans = None

  for v in vps :
    if v == "(" :
      stack.append(v)
    elif v == ")" :
      try :
        stack.pop()
      except :
        ans = "NO"
        break
  if not ans and len(stack) == 0 :
    ans = "YES"
  else :
    ans = "NO"

  print(ans)

