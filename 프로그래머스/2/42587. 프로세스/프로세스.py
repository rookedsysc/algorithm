from collections import deque
def solution(priorities, location):
  ans = 0
  q = deque(priorities)
  tar_val = priorities[location]
  
  while q : 
    cur_max_val = max(q)
    cur_val = q.popleft()
    location -= 1
    if cur_max_val == cur_val : 
      ans += 1
      if location < 0 and cur_val == tar_val : 
        break
      elif location < 0 : 
        location = len(q) + location
    else : 
      q.append(cur_val)
      if location < 0 : 
        location = len(q) + location
    
  return ans