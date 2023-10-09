from collections import deque

def solution(priorities, location):
  priorities = deque(priorities)
  target = priorities[location]
  cnt = 1
  while priorities : 
    cm = max(priorities)
    cv = priorities.popleft()
    if cv != cm : 
      priorities.append(cv)
      location -= 1
      if location < 0 : 
        location = len(priorities) - 1
      continue
    
    location -= 1
    
    if location < 0 and cv == target : 
      return cnt 
    elif location < 0 :
      location = len(priorities) - 1
      
    cnt += 1
    
  return -1