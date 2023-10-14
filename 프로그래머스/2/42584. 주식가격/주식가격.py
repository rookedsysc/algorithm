def solution(prices) :
  stack = []
  ans = [0] * len(prices) 
  for i in range(len(prices)) :
    while len(stack) != 0 and prices[stack[-1]] > prices[i] : 
      cur_i = stack.pop()
      ans[cur_i] = i - cur_i 
      
    stack.append(i)
    
  for i in stack : 
    ans[i] = len(prices) - i - 1
    
  return ans