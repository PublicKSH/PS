
board = [list(map(int, input().split())) for _ in range(4)]
result = set()
dx = [1,-1,0,0]
dy = [0,0,1,-1]

resultString = ""
def dfs(depth, y, x):
    global resultString
    if (depth) == 6:
        result.add(resultString)
    else:
       for i in range(4):
           nx = dx[i] + x
           ny = dy[i] + y 
           if 0<=nx<4 and 0<=ny<4:
               resultString = resultString + str(board[ny][nx])
               dfs(depth+1 ,ny, nx)
               resultString = resultString[:-1]

for i in range(4):
    for j in range(4):
        resultString = str(board[i][j])
        dfs(0, i, j)
print(len(result))