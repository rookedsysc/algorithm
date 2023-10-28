from functools import cmp_to_key
def custom_sort(str1, str2) : 
  if str(str1)+str(str2) > str(str2) + str(str1) :
    return -1
    
  elif str(str1)+str(str2) < str(str2) + str(str1) :
    return 1
    
  else : 
    return 0
  

def solution(numbers):
  numbers = sorted(numbers, key=cmp_to_key(custom_sort)) 
  ans = ""
  
  for n in numbers :
    ans += str(n)
  if ans[0] == "0" : 
    ans = "0"
  
  return ans
