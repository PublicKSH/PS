from collections import deque

n, m  = map(int ,input().split())
board = [[0 for i in range(m)] for j in range(n)]
for i in range(n):
    inputListNumber = input()
    for j in range(m):
        board[i][j] = int(inputListNumber[j])


dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

q = deque()
q.append((0,0))
while q:
    x,y = q.popleft()
    # 4방향으로 순회
    for i in range(4):
        nx = dx[i] + x
        ny = dy[i] + y
        if(nx >= 0 and nx < n and ny >= 0 and ny < m and board[nx][ny] == 1):
            # 처음이 다시 큐에 들어가는것을 방지하는 validation -> visited table로도 처리가능
            if (nx == 0 and ny ==0):
                continue
            board[nx][ny] = board[x][y] + 1
            q.append((nx,ny))

print(board[n-1][m-1])