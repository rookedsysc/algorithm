class Solution:
  def trap(self, height_list: list[int]) -> int : 
    stack = []
    vol = 0
    
    for i in range(len(height_list)) :
      while stack and height_list[i] > height_list[stack[-1]] :
        top = stack.pop()
        
        # 여기서 len(stack) == 0이 나오는 경우는 a, b가 연달아서 숫자가 높아졌을 때 
        # a를 append하고 바로 b가 나온다면 stack에서 top으로 pop 해주게 된다.
        if len(stack) == 0 :
          break 
        
        '''
        stack에는 변곡점에 다다르지 않은 height_list에 대한 index들이 들어있고 
        stack[-1]은
        변곡점을 만나기전 즉, 높은곳 >>> 낮은곳 >> 변곡점 >> 높은곳에서 낮은곳에 해당되는 
        것을 pop 해줬기 때문에 낮은곳에 나오기 전에 있던 첫 번째 높은 지점을 가르키고 있음
        ''' 
        distance = i - stack[-1] - 1
        # height_list[top]은 사이에 있는 값이고 
        # height_list[i]와 height_list[stack[-1]]는 height_list[top]을 사이에 두고 있는 벽이다.
        waters = min(height_list[i], height_list[stack[-1]]) - height_list[top]
        
        vol += distance * waters
      stack.append(i)
    
    return vol
