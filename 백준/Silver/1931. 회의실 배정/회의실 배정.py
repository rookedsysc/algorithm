N = int(input())
times = []
for _ in range(N) :
  time = list(map(int, input().split()))
  times.append(time)

times.sort(key=lambda x: (x[1], x[0]))
last_end = 0
cnt = 0
for start, end in times :
  if last_end <= start :
    cnt += 1
    last_end = end

print(cnt)