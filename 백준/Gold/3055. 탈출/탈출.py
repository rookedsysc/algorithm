from collections import deque

def bfs_forest_escape(R, C, forest):
    # 초기화
    water = deque()  # 물 확장 큐
    hedgehog = deque()  # 고슴도치 이동 큐
    visited = [[False] * C for _ in range(R)]  # 방문 체크

    # 초기 상태 세팅
    for r in range(R):
        for c in range(C):
            if forest[r][c] == '*':
                water.append((r, c))
            elif forest[r][c] == 'S':
                hedgehog.append((r, c, 0))  # (행, 열, 시간)
                visited[r][c] = True

    # 방향 벡터 (상, 하, 좌, 우)
    directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]

    # BFS 탐색
    while hedgehog:
        # 1. 물 확장
        for _ in range(len(water)):
            x, y = water.popleft()
            for dx, dy in directions:
                nx, ny = x + dx, y + dy
                if 0 <= nx < R and 0 <= ny < C and forest[nx][ny] == '.':
                    forest[nx][ny] = '*'  # 물 확장
                    water.append((nx, ny))

        # 2. 고슴도치 이동
        for _ in range(len(hedgehog)):
            x, y, time = hedgehog.popleft()
            for dx, dy in directions:
                nx, ny = x + dx, y + dy
                if 0 <= nx < R and 0 <= ny < C:
                    if forest[nx][ny] == 'D':  # 비버 굴 도착
                        return time + 1
                    if forest[nx][ny] == '.' and not visited[nx][ny]:
                        visited[nx][ny] = True
                        hedgehog.append((nx, ny, time + 1))

    return "KAKTUS"

# 입력 처리
R, C = map(int, input().split())
forest = [list(input().strip()) for _ in range(R)]

# 결과 출력
print(bfs_forest_escape(R, C, forest))