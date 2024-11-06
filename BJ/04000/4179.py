# # First,If 지훈 moves,the fire spreads 
# # time 1
# ####
# #FF#
# #JF#
# #..#

# # time 2
# ####
# #FF#
# #FF#
# #JF# => "Escape confirmed at time 3."

# from collections import deque
# r,c = map(int, input().split())
# board = [[0 for _ in range(c)] for _ in range(r)]
# q = deque()

# # input
# for i in range(r):
#     row = input()
#     for j in range(c):
#         if (row[j] == "J"):
#             board[i][j] = 0
#         else:
#             board[i][j] = row[j]

# for i in range(r):
#     for j in range(c):
#         if(board[i][j] == 0):
#             q.append((i,j))

# for i in range(r):
#     for j in range(c):
#         if(board[i][j] == "F"):
#             q.append((i,j))

# dx = [0, 1, 0, -1]
# dy = [1, 0, -1, 0]
# result = "IMPOSSIBLE"

# while q:
#     y,x = q.popleft()

#     if isinstance(board[y][x], int) and (y == 0 or x == 0 or y == r - 1 or x == c - 1):
#         result = board[y][x] + 1
#         break

#     for i in range(4):
#         ny = dy[i] + y
#         nx = dx[i] + x
        
#         if 0 <= ny < r and 0 <= nx < c and board[ny][nx] != "#":
#             if isinstance(board[y][x], int):
#                 if board[ny][nx] == ".":
#                     board[ny][nx] = board[y][x] + 1
#                     q.append((ny,nx))
#             elif board[y][x] == "F":
#                 if board[ny][nx] != "F":
#                     board[ny][nx] = "F"
#                     q.append((ny,nx))

# print(result)
# 논리는 맞았다... 틀린이유 -> c,r을 잘못써서..

# First,If 지훈 moves,the fire spreads 
# time 1
####
#FF#
#JF#
#..#

# time 2
####
#FF#
#FF#
#JF# => "Escape confirmed at time 3."

from collections import deque
r,c = map(int, input().split())
board = [[0 for _ in range(c)] for _ in range(r)]
q = deque()

# input
for i in range(r):
    row = input()
    for j in range(c):
        if (row[j] == "J"):
            board[i][j] = 1
        else:
            board[i][j] = row[j]

for i in range(r):
    for j in range(c):
        if(board[i][j] == 1):
            q.append((i,j))

for i in range(r):
    for j in range(c):
        if(board[i][j] == "F"):
            q.append((i,j))

dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

result = 99999 # max = 1000
while q:
    y,x = q.popleft()

    for i in range(4):
        ny = dy[i] + y
        nx = dx[i] + x
        
        if nx >= 0 and nx < c and ny >= 0 and ny < r:
            if isinstance(board[y][x], int):
                if board[ny][nx] == ".":
                    board[ny][nx] = board[y][x] + 1
                    q.append((ny,nx))
            elif board[y][x] == "F":
                if board[ny][nx] != "#" and board[ny][nx] != "F":
                    board[ny][nx] = "F"
                    q.append((ny,nx))
        else:
            if isinstance(board[y][x], int):
                if result > board[y][x]:
                    result = board[y][x]

if result != 99999:
    print(result)
else:
    print('IMPOSSIBLE')