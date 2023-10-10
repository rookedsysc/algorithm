class ListNode:
  def __init__(self, val=0, next=None):
    self.val = val
    self.next = next

from collections import deque
class Solution:
  def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode : 
    q1, q2 = deque(), deque()
    while l1 or l2 : 
      if l1 :
        q1.appendleft(str(l1.val))
        l1 = l1.next
      if l2 : 
        q2.appendleft(str(l2.val))
        l2 = l2.next
    
    max_range = max(len(q1), len(q2))
    
    str1 = ""
    str2 = ""
    
    for i in range(max_range) : 
      if i < len(q1) : 
        str1 = str1 + q1[i]
      if i < len(q2) : 
        str2 = str2 + q2[i]
    
    sum = str(int(str1) + int(str2))

    first_node = None
    pre_node: ListNode = None
    
    for i in range(len(sum) - 1, -1, -1) : 
      if pre_node : 
        pre_node.next = ListNode(val=int(sum[i]))
        pre_node = pre_node.next
      else : 
        first_node = ListNode(val=int(sum[i]))
        pre_node = first_node
        
    return first_node