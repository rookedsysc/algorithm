# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
  def lowestCommonAncestor(self, curNode: TreeNode, p: TreeNode, q: TreeNode) -> TreeNode :
    if curNode is None : 
      return None
    
    left = self.lowestCommonAncestor(curNode=curNode.left, p = p, q = q)
    right = self.lowestCommonAncestor(curNode=curNode.right, p = p, q = q)
    
    if left and right : 
      return curNode
    
    if curNode == q or curNode == p : 
      return curNode
    
    return left or right
    