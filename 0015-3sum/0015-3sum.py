class Solution:
  def threeSum(self, nums: list[int]) -> list[list[int]]:
    ans = []
    nums.sort()
    for ni in range(len(nums)): 
      l,r = ni + 1, len(nums) - 1
      while l < r :
        cr = nums[l] + nums[r] + nums[ni]
        if cr < 0 : 
          l += 1
        elif cr > 0 :
          r -= 1
        else : 
          if [nums[l], nums[r], nums[ni]] not in ans : 
            ans.append([nums[l], nums[r], nums[ni]])
          
          l += 1
          r -= 1
    return ans