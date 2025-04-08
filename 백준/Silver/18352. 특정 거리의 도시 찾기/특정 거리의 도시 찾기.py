# 다익스트라
import heapq
INF = int(1e9)

n, m, k, start = map(int, input().split())

graph = [[] for _ in range(n+1)]
distance = [INF for _ in range(n+1)]

for i in range(m):
    a, b = map(int, input().split())
    graph[a].append((b, 1))

def dijkstra(start):
    q = []
    heapq.heappush(q, (0, start))
    distance[start] = 0

    while q:
        dist, now = heapq.heappop(q)
        if distance[now] < dist:
            continue
        for i in graph[now]:
            # 현재 노드를 거쳐서 i[0] 으로 가는 비용
            cost = dist + i[1]
            if cost < distance[i[0]]:
                distance[i[0]] = cost
                heapq.heappush(q, (cost, i[0]))
dijkstra(start)

result = False
for i in range(1, n+1):
    if distance[i] == k:
        print(i)
        result = True

if not result:
    print(-1)
