from collections import deque
def solution(rc, operations):
  ROW = len(rc)
  COLUMN = len(rc[0])
  # 맨 왼쪽에 있는 컬럼들만 넣음
  left_col = deque([rc[i][0] for i in range(ROW)])
  # 맨 오른쪽에 있는 컬럼들만 넣음
  right_col = deque([rc[i][COLUMN - 1] for i in range(ROW)])
  # 외곽쪽에 있지 않은 컬럼들만 넣음
  rows = deque([deque(rc[i][1:COLUMN - 1]) for i in range(ROW)])

  for op in operations:
    if op == 'ShiftRow':
      # 각 컬럼들의 맨 앞부분에 맨 마지막 부분을 넣어줌
      left_col.appendleft(left_col.pop())
      rows.appendleft(rows.pop())
      right_col.appendleft(right_col.pop())
    else:  # 'Rotate'
      rows[0].appendleft(left_col.popleft())
      right_col.appendleft(rows[0].pop())
      rows[ROW - 1].append(right_col.pop())
      left_col.append(rows[ROW - 1].popleft())
  answer = []
  for i in range(ROW):
    answer.append([left_col[i]] + list(rows[i]) + [right_col[i]])
  return answer