
# 비어있는 리스트를 만들어서 dfs에 넣는것 까지는 맞는 접근
# 여러 수를 넣어햐한다.
board = [[] for _ in range(9)]
emptyPoint = []
for i in range(9):
    board[i] = list(map(int, input().split()))

for i in range(9):
    for j in range(9):
        if board[i][j] == 0:
            emptyPoint.append((i,j))

emptyNum = len(emptyPoint)

def isPossible(x, y, num):
    # 1. 행
    for i in range(9):
        if board[x][i] == num:
            return False
    # 2. 열
    for i in range(9):
        if board[i][y] == num:
            return False    
    # 3. 정사각형
    squareX = int((x/3)) * 3
    squareY = int((y/3)) * 3
    for i in range(squareX, squareX+3):
        for j in range(squareY, squareY+3):
            if board[i][j] == num:
                return False
    return True

# resultFlag = False

def dfs(count):
    global resultFlag
    if count == emptyNum:
        # if not resultFlag:
        for i in range(9):
            for j in range(9):
                print(board[i][j], end=' ')
            print()
        exit(0)
        # resultFlag = True
    for i in range(1,10):
        x, y = emptyPoint[count]
        if isPossible(x, y, i):
            board[x][y] = i
            dfs(count+1)
            board[x][y] = 0
            
dfs(0)