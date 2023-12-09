max = 0
max_index = 0
cnt = 1
while True :
  try :
    a = int(input())
    pre_max  = max
    if a > max :
      max = a
    if pre_max != max :
      max_index = cnt
    cnt += 1
  except Exception as e :
    break

print(max)
print(max_index)