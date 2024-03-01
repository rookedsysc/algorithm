def solution(lottos, win_nums):
    hash_tb = {6:1, 5:2, 4:3, 3:4, 2:5, 1:6, 0:6}
    low_cnt, max_cnt = 0, 0 
    for l in lottos :
        if l == 0 :
            max_cnt += 1
        elif l in win_nums :
            low_cnt += 1
            max_cnt += 1
    answer = [hash_tb[max_cnt], hash_tb[low_cnt]]
    return answer