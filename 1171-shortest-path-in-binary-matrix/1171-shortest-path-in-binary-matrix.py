from collections import deque
class Solution:
  def shortestPathBinaryMatrix(self, grid: list[list[int]]) -> int:
    if grid[0][0] == 1 or grid[-1][-1] == 1 :
      return -1 
    if len(grid) - 1 == 0 : 
      return 1
    ori_r = len(grid) 
    ori_c = len(grid[0])
    tar_r = len(grid) - 1
    tar_c = len(grid[0]) - 1
    visited = [[False for _ in range(ori_c)] for _ in range(ori_r)]
    ans = -1
    
    q = deque()
    q.append((0,0,1))
    visited[0][0] = True 
    
    while q : # type: tuple
      dx = [-1,1,0,0,-1,1,-1,1]
      dy = [0,0,-1,1,-1,1,1,-1]
      cur_r, cur_c, cur_l = q.popleft()
      
      if cur_c == tar_c and cur_r == tar_r : 
        return cur_l
      
      for i in range(len(dx)) : 
        next_r = cur_r + dx[i]
        next_c = cur_c + dy[i]
        next_l = cur_l + 1
        # 길이 확인
        if -1 < next_r < ori_r and -1 < next_c < ori_c : 
          if not visited[next_r][next_c] and grid[next_r][next_c] == 0 : 
            q.append((next_r, next_c,next_l))
            visited[next_r][next_c] = True
    return -1 
        