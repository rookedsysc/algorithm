from collections import deque

def solution(bandage, health, attacks):
  max_health = health
  q = deque(attacks)
  count = 0
  game_round = 0

  def plushealth(plus):
    if health + plus > max_health:
      return max_health
    return health + plus

  while q:
    if game_round == q[0][0]:
      _, b = q.popleft()
      health -= b
      count = 0
      if health <= 0:
        return -1
    else:
      count += 1
      if count != bandage[0]:
        health = plushealth(bandage[1])
      else:
        count = 0
        health = plushealth(bandage[2] + bandage[1])
    game_round += 1
  return health