n = int(input())
pathList = list(input().split())

print(pathList)

def moveXY(path, X, Y) :
    if (path == 'L'):
        print("L")
    elif (path == 'R'):
        print("R")
    elif (path == 'U'):
        print("U")
    elif (path == 'D'):
        print("D")

for i in range(len(pathList)):
    moveXY(pathList[i])


print(startPointX, startPointY)