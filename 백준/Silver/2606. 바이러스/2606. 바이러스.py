N = int(input())
E = int(input())
graph = [[] for _ in range(N + 1)]
visited = [False for _ in range(N + 1)]

for _ in range(E):
    a, b = map(int,input().split())
    graph[a].append(b)
    graph[b].append(a)

from collections import deque

def solve(graph):
    global visited
    q = deque([1])
    visited[1] = True
    cnt = 0
    while q:
        cur = q.popleft()
        for v in graph[cur] :
            if not visited[v]  :
                q.append(v)
                visited[v] = True
                cnt += 1

    # 1번 컴퓨터는 1번 컴퓨터로 인해서 감염된 pc가 아니므로 제외
    return cnt


print(solve(graph))
