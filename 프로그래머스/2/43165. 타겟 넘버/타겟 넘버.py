from collections import deque

def solution(numbers, target):
    q = deque([0])
    
    for n in numbers : 
        next_q = deque()
        while q : 
            cur_v = q.popleft()
            next_q.append(cur_v + n)
            next_q.append(cur_v - n)
        q = next_q
    cnt = 0 
    for i in q :
        if i == target :
            cnt += 1 
    return cnt