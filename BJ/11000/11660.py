# 세그먼트 트리 로도 풀어보자
import sys
input = sys.stdin.readline

n, m = map(int, input().split())

arr = []

for i in range(n):
    subArray = list(map(int, input().split()))
    arr.append(subArray)

sumArr = [[0]*(n+1) for i in range(n+1)]

for i in range(1, n+1):
    for j in range(1, n+1):
        sumArr[i][j] = sumArr[i][j-1] + sumArr[i-1][j] - sumArr[i-1][j-1] + arr[i-1][j-1]
        
for k in range(m):
    x1,y1,x2,y2 = map(int,input().split())
    
    result = sumArr[x2][y2] - sumArr[x2][y1-1] -sumArr[x1-1][y2] + sumArr[x1-1][y1-1]
    print(result)