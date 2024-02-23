from collections import deque


def bfs(graph, start, target):
  q = deque()
  q.append([0, start[0], start[1]])
  visited = [[False for _ in range(50)] for _ in range(50)]
  _d = [[1, 0], [-1, 0], [0, 1], [0, -1]]

  while q:
    cnt, curY, curX = q.popleft()
    if [curY, curX] == target:
      return cnt
    cnt += 1
    for d in _d:
      nextX = curX + d[0]
      nextY = curY + d[1]
      if graph[nextY][nextX] == 0:
        continue
      if (1 <= nextX <= 50) and (1 <= nextY <= 50):
        if not visited[nextY][nextX]:
          visited[nextY][nextX] = True
          q.append([cnt, nextY, nextX])
  return -1


def fillGraph(graph, r):
  lx, ly, rx, ry = r
  q = deque()
  q.append([ly + 1, lx + 1])
  visited = [[False for _ in range(51)] for _ in range(51)]
  _d = [[1, 0], [-1, 0], [0, 1], [0, -1], [1,1], [1,-1], [-1,1], [-1,-1]]

  while q:
    curY, curX = q.popleft()
    graph[curY][curX] = 0

    for d in _d:
      nextX = curX + d[0]
      nextY = curY + d[1]
      if (lx < nextX < rx) and (ly < nextY < ry):
        if not visited[nextY][nextX] :
          if graph[nextY][nextX] != 0 :
              visited[nextY][nextX] = True
              q.append([nextY, nextX])
  return graph


def solution(rectangle, characterX, characterY, itemX, itemY):
  graph = [[1 for _ in range(51)] for _ in range(51)]

  for r in rectangle:
    graph = fillGraph(graph, r)

  start = [characterY, characterX]
  end = [itemY, itemX]
  cnt = bfs(graph, start, end)

  return cnt
