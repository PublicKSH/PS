drawingPaper = [[0 for _ in range(100)] for _ in range(100)]
n = int(input())
result = 0

def drawDrawingPaperToBlack(x,y):
    # 글로벌로 선언된 drawingPaper 에 접근해서 사용
    global drawingPaper
    global result
    for i in range(x, x+10):
        for j in range(y, y+10):
            if (drawingPaper[j][i] == 0):
                result += 1
                drawingPaper[j][i] = 1

for _ in range(n):
    x,y = map(int, input().split())
    drawDrawingPaperToBlack(x,y)


print(result)