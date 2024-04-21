from collections import deque

N = int(input())
graph = [[0 for _ in range(200)] for _ in range(200)]
all_edge = deque()
visited = []
move_rule = {
  0: [0,1], 1: [-1,0], 2: [0,-1], 3: [1,0]
}
dragon_rule = {
  0:1,1:2,2:3,3:0
}
move = []

for _ in range(N):
  move = []
  x, y, d, g = map(int, input().split())

  # 다음 움직일 장소 정렬
  cur_move = move_rule[d]
  ny, nx = y + cur_move[0], x + cur_move[1]
  graph[y][x], graph[ny][nx] = 1, 1
  all_edge.append([y,x])
  all_edge.append([ny,nx])

  last = [ny, nx]
  move.append(d)
  for _ in range(g) :
    tmp = len(move) - 1
    for m in range(tmp, -1, -1) :
      # 다음 이동 결정
      nm = dragon_rule[move[m]]
      move.append(nm) # 움직인 방향 추가
      cur_move = move_rule[nm]

      # 다음 장소로 이동 후 저장
      ny, nx = last[0] + cur_move[0], last[1] + cur_move[1]
      all_edge.append([ny, nx])
      graph[ny][nx] = 1

      last = [ny,nx] # 마지막 움직인 곳 변경

cnt = 0
def check(v1, v2, v3, v4) :
  global cnt
  if graph[v1[0]][v1[1]] and graph[v2[0]][v2[1]] and graph[v3[0]][v3[1]] and graph[v4[0]][v4[1]] :
    visit = [v1, v2, v3, v4]
    visit.sort()
    if not (visit in visited) :
      cnt += 1
      visited.append(visit)

while all_edge :
  y, x = all_edge.popleft()
  # 1사분면 확인
  check([y,x], [y+1, x], [y+1, x+1], [y,x+1])
  # 2사분면 확인
  check([y,x], [y-1, x], [y-1, x+1], [y,x+1])
  # 3사분면 확인
  check([y,x], [y-1, x], [y-1, x-1], [y,x-1])
  # 4사분면 확인
  check([y,x], [y+1, x], [y+1, x-1], [y,x-1])

print(cnt)



'''
3
3 3 0 1
4 2 1 3
4 2 2 1
x,y = 드래곤 커브의 시작 점
0: [0,1], 1: [-1,0], 2: [0,-1], 3: [1,0]
0의 드래곤 커브 : 3
1의 드래곤 커브 : 0
2의 드래곤 커브 : 1
3의 드래곤 커브 : 2
[1, 2]
'''

