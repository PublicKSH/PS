INF = 1e9
n, m = map(int, input().split())
graph = [[INF] * n for _ in range(n)]
for i in range(m):
    a,b = map(int, input().split())
    graph[a-1][b-1] = 1
    graph[b-1][a-1] = 1

for i in range(n):
    for j in range(n):
        if i == j:
            graph[i][j] = 0

for k in range(n):
    for i in range(n):
        for j in range(n):
            graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])

MaxKevinBacon = INF
answer = INF

for i in range(n):
    if MaxKevinBacon > sum(graph[i]):
        MaxKevinBacon = sum(graph[i])
        answer = i + 1

print(answer)