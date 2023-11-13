class Solution:
  def trap(self, height: list[int]) -> int:
    ans = 0
    l, r = 0, len(height) - 1
    max_l, max_r = height[l], height[r]
    
    while l < r :
      if max_l > max_r :
        r-= 1
        max_r = max(max_r,height[r])
        ans += max_r - height[r]
        
      else :
        l += 1
        max_l= max(max_l,height[l])
        ans += max_l - height[l]
        
    return ans