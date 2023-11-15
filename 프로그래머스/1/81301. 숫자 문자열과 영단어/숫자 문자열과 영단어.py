def solution(s):
  n_hash = {
    '0': 0, '1': 1, '2': 2, '3': 3, '4': 4, '5': 5, '6': 6, '7': 7, '8': 8, '9': 9
  }
  a_hash = {
    "zero" : 0, 'one': 1,'two':2,'three':3,'four':4,'five':5,'six':6,'seven':7,'eight':8,'nine':9
  }
  s_list = list(s)
  ans = ""
  cur_val = ""
  while s_list :
    cur_val += s_list.pop(0)
    if cur_val in n_hash :
      ans += str(n_hash[cur_val])
      cur_val = ""
    elif cur_val in a_hash :
      ans += str(a_hash[cur_val])
      cur_val = ""
  return int(ans)