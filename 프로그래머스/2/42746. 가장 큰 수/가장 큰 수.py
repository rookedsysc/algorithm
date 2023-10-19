from functools import cmp_to_key
def custom_sort(a, b):
  if a + b > b + a:
    return -1
  elif a + b < b + a:
    return 1
  else:
    return 0 
def solution(numbers: list) : 
  numbers = list(map(lambda x: str(x), numbers))
  if numbers.count('0')==len(numbers):
    return "0"
  numbers = sorted(numbers, key=cmp_to_key(custom_sort))
  ans = ""
  for n in numbers : 
    ans += f"{n}"
  return ans
