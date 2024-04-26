L, C = map(int, input().split())
alphabet = list(map(str, input().split()))
alphabet.sort()
ans = []

def check(cur_str: list) :
  mv = ['a', 'e', 'i', 'o', 'u']
  mv_cnt = 0
  for s in cur_str :
    if s in mv :
      mv_cnt += 1
  if mv_cnt >= 1 :
    if len(cur_str) - mv_cnt >= 2:
      return True
  return False

def backtracking(cur:list, idx:int) :
  if len(cur) == L :
    if check(cur) :
      tmp = "".join(map(str, cur))
      ans.append(tmp)
    return
  for i in range(idx, C) :
    cur_val = alphabet[i]
    cur.append(cur_val)
    backtracking(cur, i + 1)
    cur.pop()

for i in range(0, C) :
  backtracking([alphabet[i]], i + 1)
for a in ans :
  print(a)