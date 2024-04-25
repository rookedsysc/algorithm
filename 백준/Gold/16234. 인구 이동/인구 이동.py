import collections
import sys
input = sys.stdin.readline
 
n, l, r = list(map(int, input().split()))
graph = [list(map(int, input().split())) for _ in range(n)]
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
 
cnt = 0
while True:
    visited = [[0] * n for _ in range(n)]
    flag = True
 
    # 인구 이동 한 세트
    for m in range(n):
        for v in range(n):
            if visited[m][v] == 0:
                queue = collections.deque([(m, v)])
                visited[m][v] = 1
 
                # (m, v) 기준으로 연합 구하기
                temp = [(m, v)]
                while queue:
                    i, j = queue.pop()
                    for z in range(4):
                        nx = i + dx[z]
                        ny = j + dy[z]
                        if 0 <= nx < n and 0 <= ny < n and visited[nx][ny] == 0:
                            if l <= abs(graph[i][j] - graph[nx][ny]) <= r:
                                queue.appendleft((nx, ny))
                                visited[nx][ny] = 1
                                temp.append((nx, ny))
 
                # 연합에 대해서 그래프 값 갱신하기
                if len(temp) > 1:
                    flag = False
                    meanv = sum([graph[i][j] for i, j in temp]) // len(temp)
                    for i, j in temp:
                        graph[i][j] = meanv
 
    if flag:  # 더 이상 인구 이동이 없으면
        break
    cnt += 1
print(cnt)
 