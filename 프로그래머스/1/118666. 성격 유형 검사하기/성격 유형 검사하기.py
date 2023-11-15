def solution(survey, choices):
  mbti_hash = {'R': 0, 'T':0, 'C':0, 'F':0,'J':0,'M':0,'A':0,'N':0}
  first = ['R','C','J','A']
  second = ['T','F','M','N']
  ans = ''
  for i in range(len(survey)) :
    if choices[i] < 4 :
      mbti_hash[survey[i][0]] += 4 - choices[i]
    elif choices[i] > 4 :
      mbti_hash[survey[i][1]] += choices[i] - 4

  for i in range(len(first)) :
    if mbti_hash[first[i]] < mbti_hash[second[i]] :
      ans += second[i]
    else :
      ans += first[i]

  return ans