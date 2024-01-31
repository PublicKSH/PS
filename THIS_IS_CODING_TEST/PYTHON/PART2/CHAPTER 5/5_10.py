import sys
sys.stdin = open("TEST_TXT/5_10_2.txt", "r")

n, m = map(int, input().split())

count = 0

graph = []

def dfs(x,y):
    if x <= -1 or y <= -1 or x >= n or y >= m:
        return False
    if graph[x][y] == 0:
        graph[x][y] = 1
        dfs(x-1,y)
        dfs(x+1,y)
        dfs(x,y-1)
        dfs(x,y+1)
        return True
    return False
# def dfs(graph, v, visited):
#     visited[v] = True
#     print(v, end=' ')
#     for i in graph[v]:
#         if not visited[i]:
#             dfs(graph, i, visited)
for i in range(n):
    graph.append(list(map(int, input())))

for i in range(n):
    for j in range(m):
        if dfs(i, j):
            count += 1

print(count)

