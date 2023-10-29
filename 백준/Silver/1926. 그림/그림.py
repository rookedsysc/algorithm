from collections import deque

n, m = map(int, input().split())
graph = []
 
for i in range(n):
    graph.append(list(map(int, input().split())))

def bfs(start_i) : 
  dr = (1,-1,0,0)
  dl = (0,0,-1,1)
  
  q = deque()
  q.append((start_i[0], start_i[1]))
  graph[start_i[0]][start_i[1]] = 0
  cnt = 1
  
  while q :
    cl, cr = q.popleft()
    for i in range(len(dr)) :
      nl = cl + dl[i]
      nr = cr + dr[i]
      if nr < 0 or nr > len(graph[0]) - 1 or nl < 0 or nl > len(graph) - 1 : 
        continue
      if graph[nl][nr] == 1 : 
        cnt += 1
        q.append((nl, nr))
        graph[nl][nr] = 0

  return cnt

def main() :
  len_of_island = [] 
  
  for l in range(len(graph)) : 
    for r in range(len(graph[0])) : 
      if graph[l][r] == 1 :
        len_of_island.append(bfs(start_i=(l, r)))
        
  if len(len_of_island) == 0 : 
    print(0)
    print(0)
  
  else :
    print(len(len_of_island))
    print(max(len_of_island))
    
main()