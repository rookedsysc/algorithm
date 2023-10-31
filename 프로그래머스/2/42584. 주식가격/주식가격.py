def solution(prices):
  ans = [0 for _ in range(len(prices))]
  stack = []
  for i in range(len(prices)) :
    while len(stack) > 0 and prices[stack[-1]] > prices[i] :
      cur_i = stack.pop()
      ans[cur_i] = i - cur_i
      
    stack.append(i)
    
  for si in stack :
    ans[si] = len(prices) - 1 - si
    
  return ans