N, M = map(int, input().split())
nums = [i for i in range(1, N + 1)]

def backtrack(curr, idx) :
  if len(curr) == M :
    print(" ".join(map(str, curr)))
    return
  for i in range(idx, len(nums)) :
    curr.append(nums[i])
    backtrack(curr, i)
    curr.pop()

backtrack(curr=[], idx=0)