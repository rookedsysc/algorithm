class Solution:
  def trap(self, height: list[int]) -> int:
    ans = 0
    lh, rh = 0, len(height) - 1 
    max_lh, max_rh = height[0], height[rh]
    
    while lh < rh :
      if max_lh > max_rh :
        rh -= 1
        max_rh = max(max_rh, height[rh])
        ans += max_rh - height[rh]
      else  :
        lh += 1
        max_lh = max(max_lh, height[lh])
        ans += max_lh - height[lh]
        
    return ans