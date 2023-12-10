test_case_count = int(input())
test_case = []

for _ in range(test_case_count):
  m, n, k = map(int, input().split())
  graph = [[False for _ in range(m)] for _ in range(n)]
  for _ in range(k):
    x, y = map(int, input().split())
    graph[y][x] = True
  test_case.append(graph)

from collections import deque

def bfs(start_v, graph, visited):
  _d = [[0, 1], [0, -1], [-1, 0],[1, 0]]
  start_r, start_c = start_v
  visited[start_r][start_c] = True
  max_r, max_c = len(graph), len(graph[0])
  q = deque()
  q.append([start_r, start_c])
  while q :
    cur_r, cur_c = q.popleft()
    for d in _d:
      next_r, next_c = (cur_r + d[0], cur_c + d[1])
      if -1 < next_r < max_r and -1 < next_c < max_c:
        if graph[next_r][next_c] and not visited[next_r][next_c]:
          q.append([next_r, next_c])
          visited[next_r][next_c] = True

  return visited

def main(test_case):
  for graph in test_case:
    row_len, column_len = len(graph), len(graph[0])
    visited = [[False for _ in range(column_len)] for _ in range(row_len)]
    cnt = 0
    for r in range(row_len):
      for c in range(column_len):
        if graph[r][c] and not visited[r][c]:
          visited = bfs([r, c], graph, visited)
          cnt += 1
    print(cnt)


main(test_case)
