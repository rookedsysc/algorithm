import heapq
import sys

sys.setrecursionlimit(10 ** 6)
input = sys.stdin.readline

n, m = map(int, input().split())  # 노드 수, 간선 수
graph = [[] for _ in range(n + 1)]
visited = [0] * (n + 1)  # 노드의 방문 정보 초기화

# 무방향 그래프 생성
for i in range(m):  # 간성 정보 입력 받기
  start, end, weight = map(int, input().split())
  graph[start].append([weight, start, end])
  graph[end].append([weight, end, start])

# 프림 알고리즘
def prim(graph, start_node):
  visited[start_node] = 1  # 방문 갱신
  candidate = graph[start_node]  # 인접 간선 추출
  heapq.heapify(candidate)  # 우선순위 큐 생성
  mst = []  # mst
  total_weight = 0  # 전체 가중치

  while candidate:
    weight, start, end = heapq.heappop(candidate)  # 가중치가 가장 적은 간선 추출
    if visited[end] == 0:  # end가 방문하지 않았다면
      visited[end] = 1  # end 방문 갱신
      mst.append((start, end))  # mst 삽입
      total_weight += weight  # 전체 가중치 갱신

      for edge in graph[end]:  # end가 start로 감
        if visited[edge[2]] == 0:  # edge[2]는 다음번 방문할 end
          heapq.heappush(candidate, edge)

  return total_weight

print(prim(graph, 1))
