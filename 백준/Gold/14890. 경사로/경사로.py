from collections import deque

N, L = map(int, input().split())
graph = []

for _ in range(N):
  line = list(map(int, input().split()))
  graph.append(line)

'''
바로 뒤 칸부터 들어와야함
'''
def check_column(v, d, visited) :
    lc = 0
    r, c = v
    nc = c
    if visited[nc] :
      return False, visited
    while -1 < nc < N :
      visited[nc] = True
      lc += 1
      if lc == L :
        return True, visited
      nc += d
      # 경사가 달라졌거나 이미 경사가 깔렸었으면
      if -1 < nc < N :
        if graph[r][nc] != graph[r][c] or visited[nc] :
         return False, visited
      else :
        break

    return False, visited

def check_row(v, d, visited) :
    lc = 0
    r, c = v
    nr = r
    if visited[nr] :
      return False, visited
    while -1 < nr < N :
      visited[nr] = True
      lc += 1
      if lc == L :
        return True, visited
      nr += d
      # 경사가 달라졌거나 이미 경사가 깔렸었으면
      if -1 < nr < N :
        if graph[nr][c] != graph[r][c] or visited[nr] :
          return False, visited
      else :
        break

    return False, visited

def main(graph):
  cnt = 0

  for r in range(N):
    prev = 0
    visited = [False for _ in range(N)]
    for c in range(N):
      if graph[r][c] == graph[r][prev] :
        pass
      elif graph[r][c] - 1 == graph[r][prev] : # 한 칸 올라간 경우
        result, visited = check_column([r,c - 1], -1, visited)
        if result :
          prev = c
        else :
          break
      elif graph[r][c] + 1 == graph[r][prev] : # 한 칸 내려간 경우
        result, visited = check_column([r,c], 1, visited)
        if result :
          prev = c
        else :
          break
      else :
        break
      # break 안당하고 마지막까지 왓으면 cnt 1 증가
      if c == N - 1 :
        cnt += 1

  for c in range(N):
    prev = 0
    visited = [False for _ in range(N)]
    for r in range(N):
      if graph[r][c] == graph[prev][c] :
        pass
      elif graph[r][c] - 1 == graph[prev][c] : # 한 칸 올라간 경우
        result, visited = check_row([r - 1,c], -1, visited)
        if result :
          prev = r
        else :
          break
      elif graph[r][c] + 1 == graph[prev][c] : # 한 칸 내려간 경우
        result, visited = check_row([r,c], 1, visited)
        if result :
          prev = r
        else :
          break
      else :
        break
      # break 안당하고 마지막까지 왓으면 cnt 1 증가
      if r == N - 1 :
        cnt += 1
  return cnt

print(main(graph))
