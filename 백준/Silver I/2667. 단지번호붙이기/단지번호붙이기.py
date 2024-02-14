R = int(input())
graph = []
for i in range(R):
    graph.append(list(input()))
visited = [[False for _ in range(R)] for _ in range(R)]
from collections import deque
def bfs(graph, start_v) :
  _d = [[1,0], [-1,0], [0,1], [0,-1]]
  q = deque([start_v])
  cnt = 1
  while q :
    r, c = q.popleft()
    for d in _d :
      nr, nc = r + d[0], c + d[1]
      if -1 < nr < R and -1 < nc < R :
        if not visited[nr][nc] and graph[nr][nc] == '1' :
          q.append([nr, nc])
          visited[nr][nc] = True
          cnt += 1
  return cnt

apart = {}
key = 1
for r in range(R) :
  for c in range(R) :
    if graph[r][c] == '1' and not visited[r][c] :
      visited[r][c] = True
      value = bfs(graph, [r,c])
      apart[key] = value
      key += 1

keys = apart.keys()
values = list(apart.values())
values.sort()
print(len(keys))
for v in values :
  print(v)