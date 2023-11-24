from collections import deque

def solution(queue1, queue2):
    ans = 0
    s1 = sum(queue1)
    s2 = sum(queue2)
    queue1 = deque(queue1)
    queue2 = deque(queue2)
    length = len(queue1)
    
    # 총 합이 홀 수인경우 절대 정답이 나올 수 없음
    if (s1 + s2) % 2 :
        return -1
    
    while ans < length * 4 :
        if s1 == s2 :
            return ans
        if s1 > s2 :
            v = queue1.popleft()
            s1 -= v
            s2 += v
            queue2.append(v)
        else :
            v = queue2.popleft()
            s1 += v
            s2 -= v
            queue1.append(v)
       	ans += 1
    return -1