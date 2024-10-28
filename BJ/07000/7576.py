from collections import deque
n,m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(m)]
q = deque()
for i in range(0,m):
    for j in range(0,n):
        if board[i][j] == 1:
            q.append((i,j))

dx = [0, 1, 0, -1]
dy = [1, 0 ,-1, 0]

while(q):
    x,y = q.popleft()
    
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if(nx >= 0 and nx < m and ny >= 0 and ny < n and board[nx][ny] == 0):
            board[nx][ny] = board[x][y] + 1
            q.append((nx,ny))


result = 0
for i in range(0,m):
    for j in range(0,n):
        if board[i][j] == 0:
            print(-1)
            exit()
        if board[i][j] > result:
            result = board[i][j]
print(result-1)
