from functools import cmp_to_key

def solution(numlist, n):
    def custom_sort(a,b) :
        if abs(n - a) > abs(n - b) :
            return 1
        elif (abs(n - a) == abs(n - b)) and a < b :
            return 1
        return -1
    answer = sorted(numlist, key=cmp_to_key(custom_sort))
    return answer