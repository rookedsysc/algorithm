def solution(dartResult):
    nums = [str(i) for i in range(11)]
    tmp = []
    ans_list = []
    answer = 0
    prev = 0
    cur = 0
    prev_val = None
    for d in list(dartResult) :
        if prev_val and d in nums :
            prev_val += str(d)
        elif d in nums : 
            prev_val = str(d)
        elif prev_val and d not in nums :
            tmp.append(prev_val)
            tmp.append(d)
            prev_val = None
        else :
            tmp.append(d)
    if prev_val :
        tmp.append(prev_val)
        
    print(tmp)
            
    for d in tmp :
        if d in nums :
            ans_list.append(prev)
            answer += prev
            prev = cur 
            cur = int(d)
        elif d.isalpha() :
            if d == 'D' :
                cur = cur ** 2
            elif d == 'T' :
                cur = cur ** 3
        elif d == '*' :
            prev *= 2
            cur *= 2
        elif d == "#" :
            cur *= -1
    answer += prev
    answer += cur 
    ans_list.append(prev)
    ans_list.append(cur)
    print(ans_list)
        
    return answer
''' 
s : ** 1
d : ** 2
t : ** 3
* : prev * 2 + cur * 2 
# : 
'''