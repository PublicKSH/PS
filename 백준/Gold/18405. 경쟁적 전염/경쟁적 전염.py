# 전염 까지는 혼자 풂
# 시간초과 해결 -> 구글링 : x,y 인덱스에 값이 퍼지면 종료

import heapq
n, k = map(int, input().split())
board = [[] for _ in range(n)]
for i in range(n):
    board[i] = list(map(int, input().split()))

s, X, Y = map(int, input().split())

def virus(virusNum, x, y):
    if x >= 0 and x < n and y >= 0 and y <n:
        if board[x][y] == 0:
            board[x][y] = virusNum
            return True
    return False

# heapq 에 (1, 위치) 이런 식으로 넣어서 heappop하면서 전염
# 시간 별로 전염되어야 할 바이러스를 담는 큐
q = [[] for _ in range(s+1)]
# 동, 남, 서, 북
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]
alreadyEnd = False
for time in range(s):
    for i in range(n):
        for j in range(n):
            if board[i][j] != 0:
                heapq.heappush(q[time], (board[i][j], (i,j)))
    while q[time]:
        virusNum ,virusPoint = heapq.heappop(q[time])
        for di in range(4): # di : direction index
            # 상 하 좌 우로 바이러스를 퍼트린다
            # 퍼트리는대 성공했을 시에만 q[time+1]에 heappush
            if(virus(virusNum, virusPoint[0]+dx[di],virusPoint[1]+dy[di])):
                if(virusPoint[0]+dx[di] == X-1 and virusPoint[1]+dy[di] == Y-1):
                    break; 
                heapq.heappush(q[time+1], (virusNum, (virusPoint[0]+dx[di],virusPoint[1]+dy[di])))
    if board[X-1][Y-1] != 0:
        print(board[X-1][Y-1])
        alreadyEnd = True
        break

if (not alreadyEnd):
    print(board[X-1][Y-1])
