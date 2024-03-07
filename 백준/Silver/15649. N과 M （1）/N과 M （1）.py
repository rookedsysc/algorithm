N, M = map(int, input().split())
nums = [i for i in range(1, N + 1)]

def backtrack(curr) :
  if len(curr) == M :
    print(" ".join(map(str, curr)))
    return
  for n in nums :
    if n not in curr :
      curr.append(n)
      backtrack(curr)
      curr.pop()

backtrack(curr=[])