## product 안쓰고 dfs 로도 풀어봐야겠다
## 

from itertools import product

n, m = map(int, input().split())
board = [list(map(int, input().split())) for _ in range(n)]

# 1 번 => 4 가지
# 2 번 => 2 가지
# 3 번 => 4 가지
# 4 번 => 4 가지
# 5 번 => 1 가지
# 따라서 4번의 for 문이면 모든 경우의 수를 구할 수 있음
# 2,5 번은 중복해서 돌리지만 computation에 큰 문제는 없다고 판단 n,m <= 8 이기 때문
# 최대 4^8 만큼 for 문이 돌아야함 (cctv 개수)

def drawBoardToDown(y, x, board):
    tempBoard = board.copy()
    for i in range(y-1, -1, -1):
        if tempBoard[i][x] == 6:
            break
        elif tempBoard[i][x] == 0:
            tempBoard[i][x] = "#"
    return tempBoard

def drawBoardToUp(y, x, board):
    tempBoard = board.copy()
    for i in range(y+1, n):
        if tempBoard[i][x] == 6:
            break
        elif tempBoard[i][x] == 0:
            tempBoard[i][x] = "#"
    return tempBoard

def drawBoardToLeft(y, x, board):
    tempBoard = board.copy()
    for i in range(x-1, -1, -1):
        if tempBoard[y][i] == 6:
            break
        elif tempBoard[y][i] == 0:
            tempBoard[y][i] = "#"
    return tempBoard

def drawBoardToRight(y, x, board):
    tempBoard = board.copy()
    for i in range(x+1, m):
        if tempBoard[y][i] == 6:
            break
        elif tempBoard[y][i] == 0:
            tempBoard[y][i] = "#"
    return tempBoard

def checkZeroInBoard(board):
    sum = 0
    for i in range(n):
        for j in range(m):
            if board[i][j] == 0:
                sum += 1
    return sum

def drawBoard(y, x, board, cctvType, directionType):
    tempBoard = board.copy()
    
    if cctvType == 1:
        # 방향에 따라 하나의 방향만 감시
        if directionType == 0:  # 오른쪽
            tempBoard = drawBoardToRight(y, x, tempBoard)
        elif directionType == 1:  # 아래쪽
            tempBoard = drawBoardToDown(y, x, tempBoard)
        elif directionType == 2:  # 왼쪽
            tempBoard = drawBoardToLeft(y, x, tempBoard)
        elif directionType == 3:  # 위쪽
            tempBoard = drawBoardToUp(y, x, tempBoard)

    elif cctvType == 2:
        # 서로 반대 방향 감시
        if directionType == 0:  # 좌우
            tempBoard = drawBoardToRight(y, x, tempBoard)
            tempBoard = drawBoardToLeft(y, x, tempBoard)
        elif directionType == 1:  # 상하
            tempBoard = drawBoardToUp(y, x, tempBoard)
            tempBoard = drawBoardToDown(y, x, tempBoard)

    elif cctvType == 3:
        # 직각 방향으로 두 방향 감시
        if directionType == 0:  # 오른쪽, 아래쪽
            tempBoard = drawBoardToRight(y, x, tempBoard)
            tempBoard = drawBoardToDown(y, x, tempBoard)
        elif directionType == 1:  # 아래쪽, 왼쪽
            tempBoard = drawBoardToDown(y, x, tempBoard)
            tempBoard = drawBoardToLeft(y, x, tempBoard)
        elif directionType == 2:  # 왼쪽, 위쪽
            tempBoard = drawBoardToLeft(y, x, tempBoard)
            tempBoard = drawBoardToUp(y, x, tempBoard)
        elif directionType == 3:  # 위쪽, 오른쪽
            tempBoard = drawBoardToUp(y, x, tempBoard)
            tempBoard = drawBoardToRight(y, x, tempBoard)

    elif cctvType == 4:
        # 세 방향 감시
        if directionType == 0:  # 왼쪽, 위쪽, 오른쪽
            tempBoard = drawBoardToLeft(y, x, tempBoard)
            tempBoard = drawBoardToUp(y, x, tempBoard)
            tempBoard = drawBoardToRight(y, x, tempBoard)
        elif directionType == 1:  # 위쪽, 오른쪽, 아래쪽
            tempBoard = drawBoardToUp(y, x, tempBoard)
            tempBoard = drawBoardToRight(y, x, tempBoard)
            tempBoard = drawBoardToDown(y, x, tempBoard)
        elif directionType == 2:  # 오른쪽, 아래쪽, 왼쪽
            tempBoard = drawBoardToRight(y, x, tempBoard)
            tempBoard = drawBoardToDown(y, x, tempBoard)
            tempBoard = drawBoardToLeft(y, x, tempBoard)
        elif directionType == 3:  # 아래쪽, 왼쪽, 위쪽
            tempBoard = drawBoardToDown(y, x, tempBoard)
            tempBoard = drawBoardToLeft(y, x, tempBoard)
            tempBoard = drawBoardToUp(y, x, tempBoard)

    return tempBoard



# (y,x, type)
cctvPointList = []
cctvDirectionList = []


# 1. 5번은 그냥 그리고 시작, 이때 cctv가 발견 되었으면 따로 정리
for i in range(n):
    for j in range(m):
        if board[i][j] == 5:
            board = drawBoardToUp(i,j, board)
            board = drawBoardToDown(i,j, board)
            board = drawBoardToRight(i,j, board)
            board = drawBoardToLeft(i,j, board)
        elif isinstance(board[i][j], int) and 1 <= board[i][j] < 5:
            cctvPointList.append((i,j, board[i][j]))
            if (board[i][j] == 2):
                cctvDirectionList.append([0,1])
            else:
                cctvDirectionList.append([0,1,2,3])

# 5번 cctv의 경우를 모두 칠하고 1차적으로 result를 구함
result = checkZeroInBoard(board)
for direction in product(*cctvDirectionList):
    if (result == 0):
        break
    tempBoard = [row[:] for row in board]
    for i in range(len(direction)):
        y,x,cctvType = cctvPointList[i]
        directionType = direction[i]

        # directionType 과 cctvType으로 board를 칠하는 코드
        tempBoard = drawBoard(y,x,tempBoard,cctvType,directionType)
        
    zeroNum = checkZeroInBoard(tempBoard)

    if result > zeroNum:
        result = zeroNum

print(result)