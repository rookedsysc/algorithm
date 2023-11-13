
class Solution:
  def __init__(self) -> None:
    self.dp_table = {}
  def climbStairs(self, n: int) -> int:
    if n == 1 : 
      return 1
    if n == 2 :
      return 2
    if n not in self.dp_table :
      self.dp_table[n] = self.climbStairs(n - 1) + self.climbStairs(n - 2)
    
    return self.dp_table[n]