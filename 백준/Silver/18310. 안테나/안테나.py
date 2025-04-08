n = int(input())
pointList = list(map(int , input().split()))
pointList.sort()
print(pointList[(n-1)//2])