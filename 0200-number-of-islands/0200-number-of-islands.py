from collections import deque
class Solution:
  def numIslands(self, grid: list[list[str]]) -> int:
    ori_row, ori_col = len(grid), len(grid[0])
    visited = [[False for _ in range(ori_col)] for _ in range(ori_row)]
    ans = 0
    
    def bfs(row, col) :
      dx = [-1,1,0,0]
      dy = [0,0,1,-1]
      visited[row][col] = True
      q = deque()
      q.append((row, col))
      
      while q : 
        cur_row, cur_col = q.popleft()
        for i in range(len(dx)) : 
          next_row = cur_row + dx[i]
          next_col = cur_col + dy[i]
          if next_row >= 0 and next_row < ori_row and next_col >= 0 and next_col < ori_col : 
            if not visited[next_row][next_col] and grid[next_row][next_col] == "1" : 
              visited[next_row][next_col] = True
              q.append((next_row, next_col))
    
    for i in range(ori_row) : 
      for j in range(ori_col) : 
        if not visited[i][j] and grid[i][j] == "1" :
          bfs(i, j)
          ans += 1

    return ans
