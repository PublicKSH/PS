
from collections import deque

m,n,h = map(int, input().split())
box = [[list(map(int, input().split())) for _ in range(n) ] for _ in range(h)]

dx = [0, 1, 0, -1, 0,0]
dy = [1,0,-1 ,0,0,0]
dz = [0,0,0,0,1,-1]
q = deque()
for i in range(h):
    for j in range(n):
        for k in range(m):
            if box[i][j][k] == 1:
                q.append((i,j,k)) # z y x

while q:
    z,y,x = q.popleft()

    for i in range(6):
        nx = x + dx[i] 
        ny = y + dy[i] 
        nz = z + dz[i]

        if nx >= 0 and nx < m and ny >= 0 and ny < n and nz >= 0 and nz < h and box[nz][ny][nx] == 0:
            box[nz][ny][nx] = box[z][y][x] + 1
            q.append((nz, ny, nx))

isRipened = True
result = 0
for i in range(h):
    for j in range(n):
        for k in range(m):
            if box[i][j][k] == 0:
                isRipened = False
            if box[i][j][k] > result:
                result  = box[i][j][k]

if not isRipened:
    print(-1)
else:
    print(result-1)