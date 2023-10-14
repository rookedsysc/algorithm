class TreeNode : 
  def __init__(self, val, right = None, left = None ) -> None:
    self.val = val
    self.left = left
    self.right = right
  
def list_to_tree(data):
  if not data:
    return None

  root = TreeNode(data[0])
  queue = [root]
  i = 1

  while queue and i < len(data):
    current = queue.pop(0)
  
  if i < len(data) and data[i] is not None:
    current.left = TreeNode(data[i])
    queue.append(current.left)
  i += 1

  if i < len(data) and data[i] is not None:
    current.right = TreeNode(data[i])
    queue.append(current.right)
  i += 1

  return root

list_for_tree = [3,5,1,6,2,0,8,None,None,7,4]
root = list_to_tree(list_for_tree)
test_node = root.left.left

graph = {
  'A' : ['B','D','E'],
  'B' : ['A','C','E'],
  'C' : ['B'],
  'D' : ['A','B'],
  'E' : ['A', 'F'],
  'F' : ['E']
}

#! ### DANGER ### 
## Tip : Test 
#! 지우면 안되는 영역
#! ### DANGER ###

class Solution:
  def threeSum(self, nums: list[int]) -> list[list[int]]:
    nums.sort()
    ans = []
    
    for i in range(len(nums)) :
      l, r = i + 1, len(nums) - 1
      while l < r : 
        cur_value = nums[i] + nums[l] + nums[r]
        if cur_value == 0 :
          if [nums[i], nums[l], nums[r]] not in ans : 
            ans.append([nums[i], nums[l], nums[r]]) 
          l += 1
          r -= 1
        elif cur_value < 0 : 
          l += 1
        else : 
          r -= 1
    
    return ans
          
        
      
      
    
