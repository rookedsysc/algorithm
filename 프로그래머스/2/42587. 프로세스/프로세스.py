def get_location(priorities:list, location: int) -> int :
  if location < 0 :
    location = len(priorities) - 1
  else :
    location -= 1
  return location

def solution(priorities: list, location: int):
  ans = 0
  
  while priorities :
    max_val = max(priorities)
    cur_val = priorities.pop(0)
    location = get_location(priorities, location)
    if cur_val != max_val :
      priorities.append(cur_val)
    else :
      ans += 1
      if location < 0 :
        return ans
  return ans