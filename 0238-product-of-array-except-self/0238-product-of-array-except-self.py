class Solution:
  def productExceptSelf(self, nums: list[int]) -> list[int]:
    ans = [1 for _ in range(len(nums))]
    pre = 1
    for idx in range(len(nums)) :
      ans[idx] *= pre
      pre *= nums[idx]
      
    pre = 1
    for idx in range(len(nums) - 1, -1, -1) : 
      ans[idx] *= pre
      pre *= nums[idx]
      
    return ans 