from collections import deque

def solution(queue1, queue2):
    answer = -2
    max_count = len(queue1) * 3 
    count = 0
    queue1 = deque(queue1)
    queue2 = deque(queue2)
    s1, s2 = sum(queue1), sum(queue2)
    
    while count < max_count :
        if s1 > s2 :
            pop_val = queue1.popleft()
            s1 -= pop_val
            s2 += pop_val
            queue2.append(pop_val)
        elif s1 < s2 :
            pop_val = queue2.popleft()
            s1 += pop_val
            s2 -= pop_val
            queue1.append(pop_val)
        else :
            return count
        count += 1
    return -1