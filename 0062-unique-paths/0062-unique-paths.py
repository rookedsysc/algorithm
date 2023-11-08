class Solution:
  def __init__(self) -> None:
    self.memory = {}
  def dfs(self, graph, location) :
    cur_r, cur_c = location
    if location == (0,1) :
      return 1
    if location == (1,0) :
      return 1
    if location not in self.memory :  
      left_side = 0
      upside = 0
      if cur_r - 1 > -1 : 
        upside = self.dfs(graph, (cur_r - 1, cur_c))
      if cur_c - 1 > -1 : 
        left_side = self.dfs(graph, (cur_r, cur_c - 1))
      self.memory[location] = upside + left_side
    return self.memory[location]
      
  def uniquePaths(self, m: int, n: int) -> int:
    if m == 1 and n == 1 : 
      return 1
    graph = [[False for _ in range(n)] for _ in range(m)]
    return self.dfs(graph, (m-1, n-1))