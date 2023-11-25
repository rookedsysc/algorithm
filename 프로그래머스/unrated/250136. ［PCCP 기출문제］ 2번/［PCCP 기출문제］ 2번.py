from collections import deque

def bfs(visited, graph, start_v) :
    d = [[1,0],[-1,0],[0,1],[0,-1]]
    q = deque()
    q.append(start_v)
    visited[start_v[0]][start_v[1]] = True
    max_r, max_c = len(graph), len(graph[0])
    count = 0
    visit_c = []
    while q :
        r, c = q.popleft()
        visit_c.append(c)
        count += 1
        for i in range(4) :
            nr, nc = r + d[i][0], c + d[i][1]
            not_out_of_range = -1 < nr < max_r and -1 < nc < max_c
            allow_access = False
            if not_out_of_range :
                allow_access = visited[nr][nc] != True and graph[nr][nc] == 1
            if allow_access :
                visited[nr][nc] = True
                q.append([nr,nc])
    return visited, count, visit_c
def solution(land):
    answer = 0
    ROW, COLUMN = len(land), len(land[0])
    visited = [[False for _ in range(COLUMN)] for _ in range(ROW)]
    시추관 = {}
    for c in range(COLUMN) :
        시추관[c] = 0

    for r in range(ROW) :
        for c in range(COLUMN) :
            if visited[r][c] is not True and land[r][c] == 1 :
                visited, count, visit_c = bfs(visited,land,[r,c])
                visit_c = list(set(visit_c))
                # print(f'visit_c : {visit_c}, start_v: [{r}, {c}], count: {count}')
                for vc in visit_c :
                    시추관[vc] += count

    print(시추관)
    return max(시추관.values())
