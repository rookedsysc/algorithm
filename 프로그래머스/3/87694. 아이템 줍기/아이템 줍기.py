from collections import deque

def bfs(graph, start, target) :
  visited = [[False for _ in range(102)] for _ in range(102)]
  direction = [[1,0], [-1,0], [0,1], [0,-1]]

  q = deque()
  q.append([start[0], start[1], 0])

  while q :
    y, x, cnt = q.popleft()
    if [y,x] == target :
      return cnt
    for d in direction :
      ny, nx = y + d[0], x + d[1]
      if -1 < ny < 102 and -1 < nx < 102 :
        if graph[ny][nx] == 1 :
          if not visited[ny][nx] :
            q.append([ny, nx, cnt + 1])
            visited[ny][nx] = True
  return -1
def solution(rectangle, characterX, characterY, itemX, itemY):
  answer = 0
  graph = [[-1 for _ in range(102)] for _ in range(102)]
  for r in rectangle:
    # 좌측 하단 x, 좌측 하단 y, 우측 상단 x, 우측 상단 y
    lx, ly, rx, ry = map(lambda x: x * 2, r)
    for y in range(ly, ry + 1):
      for x in range(lx, rx + 1):
        # 모서리인 경우
        if x == lx or x == rx or y == ly or y == ry:
          if graph[y][x] != 0 :
            graph[y][x] = 1
        else:
          # 안쪽은 접근 불가능 하도록
          graph[y][x] = 0
  answer = bfs(graph, [characterY * 2, characterX * 2], [itemY * 2, itemX * 2])  // 2
  return answer
