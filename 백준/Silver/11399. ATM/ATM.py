n = int(input())
times = list(map(int,input().split()))

times.sort()
total = 0
last = 0

for time in times :
  last += time
  total += last

print(total)

