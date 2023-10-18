from collections import deque
class Solution:
  def canVisitAllRooms(self, rooms: list[list[int]]) -> bool:
    visited = [False for _ in range(len(rooms))] 
    check_out = []
    
    def insertListToQue(q:deque, room_number: int) :
      for l in rooms[room_number] : 
        if l not in check_out and not visited[l] : 
          q.append(l)
          visited[l] = True
          check_out.append(l)
          
      return q
    
    q = deque() 
    visited[0] = True
    q = insertListToQue(q = q, room_number = 0)
    
    while q : 
      cur_q = q.popleft()
      q = insertListToQue(q = q, room_number = cur_q)
      
    return False not in visited