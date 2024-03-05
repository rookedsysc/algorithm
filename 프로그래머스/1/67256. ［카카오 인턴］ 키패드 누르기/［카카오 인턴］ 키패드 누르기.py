from collections import deque

def bfs(graph, cur_v, target) :
    _d = [[1,0], [-1,0], [0,1], [0,-1]]
    R, C = len(graph), len(graph[0])
    q = deque()
    q.append(cur_v)
    while q :
        cr, cc, c_cost = q.popleft()
        if [cr, cc] == target :
            return c_cost
        for d in _d :
            nr, nc = cr + d[0], cc + d[1]
            if -1 < nr < R and -1 < nc < C :
                q.append([nr,nc,c_cost + 1])
        
    return -1

def solution(numbers, hand):
    answer = ""
    graph = [[i + j * 3 for i in range(1, 4)] for j in range(3)] + [["*", 0, "#"]]
    htb = {}
    R, C = len(graph), len(graph[0])
    for r in range(R) :
        for c in range(C) :
            htb[graph[r][c]] = [r,c]
    left, right = [3,0],[3,2]
    for n in numbers :
        if n in [1,4,7] : 
            left = htb[n]
            answer += "L"
        elif n in [3,6,9] :
            right = htb[n]
            answer += "R"
        else :
            lcost = bfs(graph, left + [0], htb[n])
            rcost = bfs(graph, right + [0], htb[n])
            if lcost > rcost :
                right = htb[n]
                answer += "R"
            elif rcost > lcost : 
                left = htb[n]
                answer += "L"
            else :
                if hand == "right" :
                    right = htb[n]
                    answer += "R"
                else :
                    left = htb[n]
                    answer += "L"
            
    return answer