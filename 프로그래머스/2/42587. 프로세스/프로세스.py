from collections import deque

def calc_location(priorites, location) : 
  location -= 1 
  if location < 0 :
    location = len(priorites) - 1
  return location

def solution(priorities, location):
  ans = 0
  q = deque(priorities)
  
  while q : 
    cur_max = max(q)
    cur_val = q.popleft()
    if cur_max == cur_val : 
      ans += 1
      if location == 0 :
        return ans
      else : 
        location = calc_location(q, location)
    
    else :
      q.append(cur_val)
      location = calc_location(q, location)
      
  return ans