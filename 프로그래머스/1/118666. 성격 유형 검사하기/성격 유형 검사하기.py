def solution(survey, choices):
    ans = ''
    mbti_hash = { 'R':0, 'C':0,'J':0,'A':0,'T':0,'F':0,'M':0,'N':0}
    
    for i in range(len(choices)):
        if choices[i] > 4 :
            mbti_hash[survey[i][1]] += choices[i] - 4
        
        elif choices[i] < 4 :
            mbti_hash[survey[i][0]] += 4 - choices[i]
    
    first = [ 'R', 'C', 'J','A' ]
    second = [ 'T', 'F', 'M','N' ]
    
    for i in range(len(first)):
        if mbti_hash[first[i]] >= mbti_hash[second[i]] :
            ans += first[i]
        else :
            ans += second[i]
        
    return ans