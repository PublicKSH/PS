n,m = map(int, input().split())
INF = 9
mapList = [[INF] * (n) for _ in range(n)]


for i in range(n):
    for j in range(n):
        if i == j:
            mapList[i][j] = 0

for i in range(m):
    a, b = map(int, input().split())
    mapList[a-1][b-1] = 1


for k in range(n):
    for i in range(n):
        for j in range(n):
            if mapList[i][j] > mapList[i][k] + mapList[k][j]:
                mapList[i][j] = mapList[i][k] + mapList[k][j]

for i in range(n):
    print(mapList[i])
