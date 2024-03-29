# 답은 맞았는데 출력형식 안바꿈
n = int(input())
m = int(input())
INF = 1e9
mapList = [[INF] * (n) for _ in range(n)]


for i in range(n):
    for j in range(n):
        if i == j:
            mapList[i][j] = 0

for i in range(m):
    a, b, c = map(int, input().split())
    if mapList[a-1][b-1] > c:
        mapList[a-1][b-1] = c

for k in range(n):
    for i in range(n):
        for j in range(n):
            if mapList[i][j] > mapList[i][k] + mapList[k][j]:
                mapList[i][j] = mapList[i][k] + mapList[k][j]

for i in range(n):
    print(mapList[i])
# 5
# 14
# 1 2 2
# 1 3 3 
# 1 4 1
# 1 5 10
# 2 4 2
# 3 4 1
# 3 5 1
# 4 5 3
# 3 5 10
# 3 1 8
# 1 4 2
# 5 1 7
# 3 4 2
# 5 2 4