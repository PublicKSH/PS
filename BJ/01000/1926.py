from collections import deque

# bfs 대표 문제
n,m = map(int, input().split())
arr =[[] for _ in range(n)]
visited =[[False for _ in range(m)] for _ in range(n)]
dx = [0, 1, 0, -1]
dy = [1, 0, -1 ,0]
results = []

for i in range(n):
    arr[i] = list(map(int, input().split()))

def bfs(y,x):
    if(not visited[y][x] and arr[y][x] == 1):
        result = 0
        visited[y][x] = True

        que = deque()
        que.append((y,x))
        while que:
            y,x = que.popleft()
            result += 1
            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if nx >= 0 and nx < m and ny >= 0 and ny < n and not visited[ny][nx] and arr[ny][nx] == 1:
                    que.append((ny,nx))
                    visited[ny][nx] = True


        results.append(result)

for i in range(n):
    for j in range(m):
        bfs(i,j)

print(len(results))
if (len(results) != 0):
    print(max(results))
else:
    print(0)