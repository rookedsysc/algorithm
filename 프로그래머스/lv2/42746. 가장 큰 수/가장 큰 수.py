from functools import cmp_to_key

def custom_sort(a, b) : 
  if (a+b) > (b+a) :
    return -1
  elif (b+a) > (a+b) :
    return 1
  return 0

def solution(numbers):
  new_numbers = []
  for n in numbers :
    new_numbers.append(str(n))
    
  new_numbers = sorted(new_numbers, key=cmp_to_key(custom_sort))

  ans = ""
  for nn in new_numbers :
    ans += nn
    
  if new_numbers[0] == "0" :
    ans = "0"
    
  return ans