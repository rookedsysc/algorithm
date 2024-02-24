N = int(input())
tri = []

for _ in range(N) :
  tri.append(list(map(int, input().split())))

for depth in range(N - 1, -1, -1) :
  if depth == N - 1 :
    continue
  COLUMN = depth + 1
  for c in range(COLUMN) :
    tri[depth][c] = max(tri[depth+1][c] + tri[depth][c], tri[depth+1][c+1] + tri[depth][c])

print(tri[0][0])