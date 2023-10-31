class Solution:
  def trap(self, height: list[int]) -> int:
    ans = 0
    l, r = 0, len(height) - 1
    max_l, max_r = height[l], height[r]
    while l <= r : 
      if max_r < max_l :
        if max_r > height[r] :
          ans += max_r - height[r]
        max_r = max(max_r,height[r])
        r -= 1
        
      else :
        if max_l > height[l] : 
          ans += max_l - height[l]
        max_l = max(max_l,height[l])
        l += 1
        
    return ans
  