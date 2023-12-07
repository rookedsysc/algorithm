string = input()

count = 0
flag = False
for i in range(len(string)) :
  if string[i] != " " :
    if not flag :
      count += 1
      flag = True
  else :
    flag = False

print(count)