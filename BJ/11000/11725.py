import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
arr = [[] for _ in range(N+1)]
result = [0 for _ in range(N+1)]
visited = [False for _ in range(N+1)]
for i in range(N-1):
    a,b = map(int, input().split())
    arr[a].append(b)
    arr[b].append(a)

def bfs(graph, start, visited):
    queue = deque()
    queue.append(start)
    visited[start] = True
    while queue:
        v = queue.popleft()
        
        for i in graph[v]:
            if not visited[i]:
                if result[i] == 0:
                    result[i] = v
                queue.append(i)
                visited[i] = True

bfs(arr, 1, visited)

for i in range(2, N+1):
    print(result[i])