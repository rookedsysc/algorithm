K, L, N = list(map(int, input().split()))
arr = list(map(int, list(input())))

nothing = True
flush = False
flush_time = 0
count = 0

time = 0
for i in arr:
    time += 1 
    if flush: 
        if (i == 1):
          count = 0
          flush_time = time
        else:
            if count + 1 == L:
              print(time)
              flush = False
              count = 0
              nothing = False
            else:
              count += 1
    else:
        if i == 1: 
            if count + 1 == K: 
                count = 0
                flush = True
                flush_time = time
            else:
                count += 1
        else:
            count = 0

if (flush):
  print(flush_time + L)
elif nothing:
  print('NIKAD')
