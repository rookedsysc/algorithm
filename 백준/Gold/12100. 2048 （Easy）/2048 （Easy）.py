import sys
from copy import deepcopy
input = sys.stdin.readline

# INPUT
n = int(input())
board = [list(map(int, input().split())) for _ in range(n)]
answer = 0

# UP
def up(board):
    for c in range(n):
        pointer = 0
        for r in range(1, n):
            if board[r][c]:
                cur = board[r][c]
                board[r][c] = 0
                # 포인터가 가리키는 수가 0일 때
                if board[pointer][c] == 0:
                    board[pointer][c] = cur
                # 포인터가 가리키는 수와 현재 위치의 수가 같을 때
                elif board[pointer][c]  == cur:
                    board[pointer][c] *= 2
                    pointer += 1
                # 포인터가 가리키는 수와 현재 위치의 수가 다를 때
                else:
                    pointer += 1
                    board[pointer][c] = cur
    return board

# DOWN
def down(board):
    for c in range(n):
        pointer = n - 1
        for r in range(n - 2, -1, -1):
            if board[r][c]:
                cur = board[r][c]
                board[r][c] = 0
                if board[pointer][c] == 0:
                    board[pointer][c] = cur
                elif board[pointer][c]  == cur:
                    board[pointer][c] *= 2
                    pointer -= 1
                else:
                    pointer -= 1
                    board[pointer][c] = cur
    return board

# LEFT
def left(board):
    for r in range(n):
        pointer = 0
        for c in range(1, n):
            if board[r][c]:
                cur = board[r][c]
                board[r][c] = 0
                if board[r][pointer] == 0:
                    board[r][pointer] = cur
                elif board[r][pointer]  == cur:
                    board[r][pointer] *= 2
                    pointer += 1
                else:
                    pointer += 1
                    board[r][pointer]= cur
    return board

# RIGHT
def right(board):
    for r in range(n):
        pointer = n - 1
        for c in range(n - 2, -1, -1):
            if board[r][c]:
                cur = board[r][c]
                board[r][c] = 0
                if board[r][pointer] == 0:
                    board[r][pointer] = cur
                elif board[r][pointer]  == cur:
                    board[r][pointer] *= 2
                    pointer -= 1
                else:
                    pointer -= 1
                    board[r][pointer] = cur
    return board


# DFS
def dfs(board, cnt):
    if cnt == 5:
        # 2차원 배열 요소 중 가장 큰 값 반환
        return max(map(max, board))

    # 상, 하, 좌, 우로 움직여 리턴한 값들 중 가장 큰 값 반환
    # board를 꼭 deepcopy하여 함수를 거친 board값이 다음 함수에 들어가지 못하도록 해주어야 한다.
    return max(dfs(up(deepcopy(board)), cnt + 1), dfs(down(deepcopy(board)), cnt + 1), dfs(left(deepcopy(board)), cnt + 1), dfs(right(deepcopy(board)), cnt + 1))

print(dfs(board, 0))
