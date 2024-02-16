def solution(friends, gifts):
    N = len(friends)
    gift_point = {}
    idx_hash = {}
    gift_hash = {}
    double_list = [[0 for _ in range(N)]for _ in range(N)]  
    cnt = 0 
    print(double_list)
    for f in friends :
        gift_point[f] = 0
        gift_hash[f] = 0
        idx_hash[f] = cnt
        cnt += 1
    
    for g in gifts :
        a, b = g.split(' ')
        gift_point[a] += 1
        gift_point[b] -= 1
        a_idx, b_idx = idx_hash[a], idx_hash[b]
        double_list[a_idx][b_idx] += 1
        
    for i in range(N - 1) :
        for n in range(i + 1, N) :
            a, b = friends[i], friends[n]
            a_idx, b_idx = idx_hash[a], idx_hash[b]
            # a가 b보다 많이 받은 경우
            if double_list[a_idx][b_idx] > double_list[b_idx][a_idx] :
                gift_hash[a] += 1
            elif double_list[a_idx][b_idx] < double_list[b_idx][a_idx] :
                gift_hash[b] += 1
            else :
                if gift_point[a] > gift_point[b] :
                    gift_hash[a] += 1
                elif gift_point[a] < gift_point[b] :
                    gift_hash[b] += 1 
    max_v = 0
    for f in friends :
        max_v = max(gift_hash[f], max_v)
        
    return max_v