from collections import deque

def solution(queue1, queue2):
    queue1, queue2 = deque(queue1),deque(queue2)
    count, max_count = 0, len(queue1) * 3
    sum1, sum2 = sum(queue1), sum(queue2)
    while count < max_count : 
        if sum1 > sum2 :
            cur_val = queue1.popleft()
            queue2.append(cur_val)
            sum1 -= cur_val
            sum2 += cur_val
        elif sum2 > sum1 :
            cur_val = queue2.popleft()
            queue1.append(cur_val)
            sum1 += cur_val
            sum2 -= cur_val
        else :
            return count 
        count += 1
    
    return -1