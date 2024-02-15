from collections import deque
import sys

sys.setrecursionlimit(10**6)
input = sys.stdin.readline

V, E = map(int, input().split())
graph = [[] for _ in range(V + 1)]
visited = [False] * (V + 1)
visited[0] = True

for _ in range(E) :
  a,b = map(int, input().split())
  graph[a].append(b)
  graph[b].append(a)
  
def bfs(graph, start) :
  q = deque([start])
  while q :
    cur = q.popleft()
    for v in graph[cur] :
      if not visited[v] :
        q.append(v)
        visited[v] = True
cnt = 0
for i in range(len(visited)) :
  if not visited[i] :
    cnt += 1
    visited[i] = True
    bfs(graph, i)

print(cnt)