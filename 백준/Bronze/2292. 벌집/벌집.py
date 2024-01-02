n = int(input())
shortest, biggest = 1, 1
cnt = 1
while not(shortest <= n <= biggest) :
  cnt += 1
  shortest = biggest + 1
  biggest = shortest + ((cnt-1) * 6) - 1

print(cnt)