class Solution:
  def __init__(self) -> None:
    self.memory = {}
  def dfs(self, n:int) -> int :
    if n == 1 :
      return 1
    if n == 2 :
      return 2
    
    if n not in self.memory :
      self.memory[n] = self.dfs(n - 1) + self.dfs(n - 2)
    
    return self.memory[n]
    
  def climbStairs(self, n: int) -> int:
    return self.dfs(n)
  
print(Solution().climbStairs(3))