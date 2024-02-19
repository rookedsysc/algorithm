from collections import defaultdict

def find_centroid(graph, inDegree, outDegree):
    # centroid = 중심 시작점: 들어오는 엣지 없고, 나가는 엣지 2개 이상임 (유일)
    for node in graph.keys():
        if inDegree[node] == 0 and outDegree[node] >= 2:
            return node

def count_graphs(centroid, graph, inDegree, outDegree):
    count = [0, 0, 0] # 도넛 모양, 막대 모양, 8자 모양
    visited = set()
    for start in graph[centroid]: # 중심 시작점이 갈 수 있는 모든 노드에 대해 탐색
        visited.add(start)
        curr = start
        while curr:
            if outDegree[curr] == 0: # 나가는 엣지 없음: 막대 모양
                count[1] += 1
                break
            elif outDegree[curr] == 2: # 나가는 엣지 2개: 8자 모양의 중심
                count[2] += 1
                break
            curr = graph[curr][0] # 다음으로 이동
            if curr in visited and outDegree[curr] == 1: # 이미 방문한 노드면서 나가는 엣지 1개면 도넛
                count[0] += 1
                break
            visited.add(curr)
    return [centroid] + count

def solution(edges):
    graph = defaultdict(list)
    inDegree = defaultdict(int) # 들어오는 엣지 개수
    outDegree = defaultdict(int) # 나가는 엣지 개수
    for start, end in edges:
        graph[start].append(end)
        inDegree[end] += 1
        outDegree[start] += 1

    centroid = find_centroid(graph, inDegree, outDegree)
    return count_graphs(centroid, graph, inDegree, outDegree)

