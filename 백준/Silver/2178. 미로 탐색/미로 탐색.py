R, C = map(int, input().split())
graph = []
for i in range(R):
    graph.append(list(input()))

from collections import deque
def bfs(graph) :
  V = [[1,0,],[-1,0],[0,1],[0,-1]]
  q = deque([[1,0,0]])
  goal = [R-1, C-1]
  visited = [[False for _ in range(C)] for _ in range(R)]

  while q :
    cost, r, c = q.popleft()
    if [r,c] == goal :
      return cost
    cost += 1
    for v in V :
      nr, nc = r + v[0], c + v[1]
      if -1 < nr < R and -1 < nc < C :
        if graph[nr][nc] != "0" and not visited[nr][nc] :
          q.append([cost, nr, nc])
          visited[nr][nc] = True
  return -1

print(bfs(graph))