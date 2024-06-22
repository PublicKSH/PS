# 1012번

import sys
sys.setrecursionlimit(10000)
def dfs(x, y, visited, a):
    if x < 0 or x >= M or y < 0 or y >= N:
        return False
    if not visited[x][y] and a[x][y] == 1:
        visited[x][y] = True
        directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]
        for dx, dy in directions:
            nx, ny = x + dx, y + dy
            dfs(nx, ny, visited, a)
        return True
    return False

T = int(input())
for _ in range(T):
    M, N, K = map(int, input().split())
    a = [[0] * N for _ in range(M)]
    for _ in range(K):
        x, y = map(int, input().split())
        a[x][y] = 1

    
    count = 0
    visited = [[False] * N for _ in range(M)]
    for i in range(M):
        for j in range(N):
            if dfs(i, j, visited, a):
                count += 1
    print(count)
    
  
  
    
T = int(input()) #테스트케이스의 개수

dx = [-1,1,0,0]
dy = [0,0,-1,1]

def BFS(x,y):           
    queue = [(x,y)]
    matrix[x][y] = 0 # 방문처리

    while queue:
        x,y = queue.pop(0)

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= M or ny < 0 or ny >= N:
                continue

            if matrix[nx][ny] == 1 :
                queue.append((nx,ny))
                matrix[nx][ny] = 0

# 행렬만들기
for i in range(T):
    M, N, K = map(int,input().split())
    matrix = [[0]*(N) for _ in range(M)]
    cnt = 0

    for j in range(K):
        x,y = map(int, input().split())
        matrix[x][y] = 1

    for a in range(M):
        for b in range(N):
            if matrix[a][b] == 1:
                BFS(a,b)
                cnt += 1

    print(cnt)