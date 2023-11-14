from collections import deque
def solution(cap, n, deliveries, pickups):
  ans = 0
  di = deque()
  pi = deque()
  for i in range(n):
    if deliveries[i] > 0:
      di.append(i)
    if pickups[i] > 0:
      pi.append(i)

  while di or pi:
    cur_di = None
    cur_pi = None
    max_i = None
    if len(di) > 0:
      cur_di = di.pop()
    if len(pi) > 0:
      cur_pi = pi.pop()

    if cur_di is None and cur_pi is not None:
      max_i = cur_pi
    elif cur_di is not None and cur_pi is None:
      max_i = cur_di
    else:
      max_i = max(cur_di, cur_pi)

    ans += (max_i + 1) * 2


    for i in range(cap):
      if cur_di is not None:
        deliveries[cur_di] -= 1
        if deliveries[cur_di] == 0 and len(di) > 0:
          cur_di = di.pop()
      if cur_pi is not None:
        pickups[cur_pi] -= 1
        if pickups[cur_pi] == 0 and len(pi) > 0:
          cur_pi = pi.pop()

    if cur_di is not None and deliveries[cur_di] > 0 :
        di.append(cur_di)
    if cur_pi is not None and pickups[cur_pi] > 0 :
        pi.append(cur_pi)
  return ans
