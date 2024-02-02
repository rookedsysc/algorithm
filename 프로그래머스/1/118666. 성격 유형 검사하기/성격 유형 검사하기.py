def solution(survey, choices):
    types = {"R": 0, "T":0, "C":0, "F":0,"J":0,"M":0, "A":0, "N":0} 
    scope = ["RT", "CF", "JM", "AN"]
    answer = ''
    
    for i in range(len(survey)) :
        choice = choices[i]
        if choice > 4 :
            types[survey[i][0]] += choice - 4
        elif choice < 4 :
            types[survey[i][1]] += 4 - choice
    
    for s in scope :
        if types[s[1]] < types[s[0]] :
            answer += s[1]
        else :
            answer += s[0]
        
    return answer