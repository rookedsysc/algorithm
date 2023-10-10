class Solution:
  def trap(self, height: list[int]) -> int:
    ans = 0
    left = 0
    right = len(height) - 1
    max_left = max(left, height[left])
    max_right = max(left, height[right])
    while left < right : 
      max_left = max(height[left], max_left) 
      max_right = max(height[right], max_right)
      
      if max_left <= max_right : 
        ans += max_left - height[left]
        left += 1
      else : 
        ans += max_right - height[right]
        right -= 1
        
    return ans

        