from collections import deque

wheel = deque()

for _ in range(4) :
  tmp = deque(map(int,input()))
  wheel.append(tmp)

cycle_cnt = int(input())
cycle = []
for _ in range(cycle_cnt) :
  cycle.append(list(map(int, input().split())))
visited = [False for _ in range(4)]
def rotate(idx, d) :
  visited[idx] = True
  if 0 < idx : # 맨 왼쪽에 있는게 아니라면
    # 왼쪽의 2시방향과 나의 6시 방향을 비교해서 다르면
    if wheel[idx - 1][2] != wheel[idx][6] :
      if not visited[idx - 1] :
        rotate(idx - 1, d * -1)
  if idx < 3 :
    if wheel[idx + 1][6] != wheel[idx][2] :
      if not visited[idx + 1] :
        rotate(idx + 1, d * -1)

  if d == 1 :
    wheel[idx].appendleft(wheel[idx].pop())
  else :
    wheel[idx].append(wheel[idx].popleft())

for c in cycle :
  visited = [False for _ in range(4)]
  rotate(c[0] - 1, c[1])

cnt = 0
for i in range(4) :
  if wheel[i][0] == 1 :
    cnt += 2 ** i

print(cnt)
