def custom_sort(a,b) :
    a, b = str(a), str(b)
    if a + b >= b + a :
        return -1
    return 1
    
from functools import cmp_to_key
def solution(numbers):
    ans = ""
    numbers = sorted(numbers, key=cmp_to_key(custom_sort))
    for n in numbers :
        ans += str(n)
    
    if ans[0] == "0" :
        return "0"
        
    return ans