from functools import cmp_to_key

def custom_sort(a,b) :
  a, b = str(a), str(b)
  if b + a > a + b : 
    return 1
  elif a + b > b + a : 
    return -1
  
  return 0

def solution(numbers):
  answer = ''
  new_numbers = sorted(numbers, key=cmp_to_key(custom_sort))
  for n in new_numbers :
    answer += str(n)
  if answer[0] == "0" :
    return "0"
  return answer