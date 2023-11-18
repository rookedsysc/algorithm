def solution(survey, choices):
    mbti_table = {"R": 0, "T": 0, "C":0,"F":0,"J":0,"M":0,"A":0,"N":0,}
    ans = ""
    
    for i in range(len(survey)) :
        if choices[i] > 4 :
            mbti_table[survey[i][1]] += choices[i] - 4
        elif choices[i] < 4 :
            mbti_table[survey[i][0]] += 4 - choices[i]
            
    first = ['R','C','J','A']
    second = ['T','F','M','N']
    print(mbti_table)
    
    for i in range(len(first)) :
        if mbti_table[second[i]] > mbti_table[first[i]] :
            ans += second[i]
        else :
            ans += first[i]
    
    return ans 