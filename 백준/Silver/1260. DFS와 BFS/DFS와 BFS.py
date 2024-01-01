import sys
input = sys.stdin.readline
v, e, start_v = map(int, input().split())
dfs_result = []
graph = {}

for i in range(1, v + 1) :
  graph[i] = []

for _ in range(e) :
  a, b = map(int, input().split())
  graph[a].append(b)
  graph[b].append(a)

from collections import deque
def bfs(graph, start_v) :
  q = deque([start_v])
  visited = []
  while q :
    cur_v = q.popleft()
    if cur_v not in visited :
      visited.append(cur_v)
      next_v_list = graph[cur_v]
      next_v_list.sort()
      for v in next_v_list :
        if v not in visited :
          q.append(v)
  return visited

def dfs(cur_v) :
  global dfs_result, graph
  dfs_result.append(cur_v)
  next_v_list = graph[cur_v]
  next_v_list.sort()
  for v in next_v_list :
    if v not in dfs_result :
      dfs(v)

dfs(start_v)
dfs_string = ""
for d in dfs_result :
  dfs_string += str(d) + " "
bfs_string = ""
for d in bfs(graph, start_v) :
  bfs_string += str(d) + " "

print(dfs_string)
print(bfs_string)