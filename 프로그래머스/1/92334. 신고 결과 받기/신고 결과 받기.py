def solution(id_list, report, k):
    user_hash, count_hash = {}, {}
    answer = []
    
    for i in id_list :
        user_hash[i] = []
        count_hash[i] = 0
    for r in report :
        fromu, tou = r.split(" ")
        if fromu not in user_hash[tou] :
            user_hash[tou].append(fromu)
    for i in id_list :
        if len(user_hash[i]) >= k :
            for u in user_hash[i] :
                count_hash[u] += 1
    for i in id_list :
        answer.append(count_hash[i])

    return answer