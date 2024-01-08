from collections import deque


def solution(bandage, health, attacks):
  answer = 0
  gmcnt = 0
  cnt = 0
  maxhp = health
  attacks = deque(attacks)

  while attacks:
    # 공격이 있다면
    if attacks[0][0] == gmcnt:
      attack = attacks.popleft()
      health -= attack[1]
      # 연속 공격 초기화
      cnt = 0
      # 죽으면 -1 리턴
      if health <= 0:
        return -1
    # 공격이 없는 경우
    else:
      cnt += 1
      # 연속 공격 성공했을 경우
      if bandage[0] == cnt:
        cnt = 0
        health = min(maxhp, health + bandage[1] + bandage[2])
      else:
        health = min(maxhp, health + bandage[1])
    gmcnt += 1

  return health



