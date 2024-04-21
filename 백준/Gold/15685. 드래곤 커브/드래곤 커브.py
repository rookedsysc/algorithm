import sys

input = sys.stdin.readline

# 동-북-서-남
dx = [0, -1, 0, 1]
dy = [1, 0, -1, 0]

if __name__ == "__main__":
    n = int(input())
    board = [[0] * 101 for _ in range(101)]
    for _ in range(n):
        # ⚠️ 좌표 주의! 문제에서는 가로가 x, 세로가 y
        # 근데 일반적으로 나는 문제를 풀때 가로가 y, 세로가 x이므로 순서 전환 필요
        y, x, d, g = map(int, input().split())
        board[x][y] = 1
        temp = [d]
        q = [d]  # 이동방향
        for _ in range(g + 1):  # 0~g세대
            for k in q:
                x += dx[k]
                y += dy[k]
                board[x][y] = 1
            q = [(i + 1) % 4 for i in temp]
            q.reverse()
            temp = temp + q

    result = 0
    for i in range(100):
        for j in range(100):
            if (
                board[i][j]
                and board[i][j + 1]
                and board[i + 1][j]
                and board[i + 1][j + 1]
            ):
                result += 1

    print(result)
