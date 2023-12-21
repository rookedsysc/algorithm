from functools import cmp_to_key

def custom_sort(a, b) :
    a = str(a)
    b = str(b)
    if b + a > a + b :
        return 1
    return -1

def solution(numbers):
    ans = ""
    numbers = sorted(numbers, key=cmp_to_key(custom_sort))
    
    for n in numbers :
        ans += str(n)
    
    if ans[0] == "0" :
        return "0"
    
    return ans