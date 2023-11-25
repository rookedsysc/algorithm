def solution(bandage, health, attacks):
  max_health = health
  count = 0
  repeat, sh, ph = bandage[0], bandage[1], bandage[2]
  attacks_hash = {}
  for a in attacks:
    i, d = a[0], a[1]
    attacks_hash[i] = d
  keys = attacks_hash.keys()
  for i in range(attacks[-1][0] + 1):
    if i in keys:  # 이번 차수 공격이 있는 경우
      health -= attacks_hash[i]
      if health < 1:  # 체력 0이하시 사망
        return -1
      else:
        count = 0
    else:
      count += 1
      if count == repeat:
        health = health + sh + ph  # 추가 체력 줌
        count = 0
        if health > max_health:
          health = max_health
      else:
        health += sh
        if health > max_health:
          health = max_health
  return health
