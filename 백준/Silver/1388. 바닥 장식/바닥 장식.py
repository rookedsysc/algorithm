R, C = map(int, input().split())
visited = [[False for _ in range(C)] for _ in range(R)]
floor = []

for _ in range(R) :
    floor.append(list(input()))

from collections import deque

q = deque([[0],[0]])
upAndDown = [[1,0], [-1,0]]
leftAndRight = [[0,1], [0,-1]]

def bfs(start, d, check_sum) :
    global visited, floor
    q = deque([start])
    while q :
        cr, cc = q.popleft()
        visited[cr][cc] = True
        for dr, dc in d :
            nr, nc = cr + dr, cc + dc
            if -1 < nr < R and -1 < nc < C :
                if (not visited[nr][nc]) and floor[nr][nc] == check_sum :
                    q.append([nr, nc])

cnt = 0
for r in range(R) :
    for c in range(C) :
        if not visited[r][c] :
            cnt += 1
            if floor[r][c] == "-" :
                bfs([r,c], leftAndRight, "-")
            else :
                bfs([r,c], upAndDown, "|")

print(cnt)