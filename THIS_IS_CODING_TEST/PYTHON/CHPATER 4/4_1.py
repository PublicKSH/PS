n = int(input())
pathList = list(input().split())
x, y = 1, 1

def moveXY(path, x, y) :
    nextX = x
    nextY = y
    if (path == 'L'):
        nextY -= 1
    elif (path == 'R'):
        nextY += 1
    elif (path == 'U'):
        nextX -= 1
    elif (path == 'D'):
        nextX += 1

    if nextX < 1 or nextX > n or nextY < 1 or nextY > n:
        return x, y
    
    return nextX, nextY

for i in range(len(pathList)):
    x, y = moveXY(pathList[i], x, y)


print(x, y)