N, M = map(int, input().split())
graph = []
dp = [100 for _ in range(M)]

chick = []
house = []

for n in range(N) :
    graph.append(list(map(int, input().split())))

for r in range(N) :
    for c in range(N) :
        if graph[r][c] == 2 :
            chick.append([r,c])
        elif graph[r][c] == 1 :
            house.append([r,c])

len_chick = len(chick)
chick_combi = []

def backtracking(curr, idx) :
    if len(curr) == M :
        chick_combi.append(curr[:])
        return
    for i in range(idx, len_chick) :
        curr.append(i)
        backtracking(curr, i + 1)
        curr.pop()

backtracking([], 0)
sum_list = []
for c in chick_combi : # 치킨 조합을 순회
    cur_sum = 0
    for h in house : # 집에 따라서
        min_value = 100
        for _c in c : # 더 가까운 거리를 합함
            cur_chick = chick[_c]
            tmp = abs(h[0] - cur_chick[0]) + abs(h[1] - cur_chick[1])
            min_value = min(min_value, tmp)
        cur_sum += min_value
    sum_list.append(cur_sum) # 현재 조합의 최단 거리를 list에 넣음

print(min(sum_list)) # 최단 거리 중에서도 최단 거리 출력


