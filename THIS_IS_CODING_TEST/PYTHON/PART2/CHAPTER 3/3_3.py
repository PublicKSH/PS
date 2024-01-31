n, m = map(int, input().split())
result = 0

for i in range(n):
    data = list(map(int, input().split()))
    minNumInRow = min(data)
    if minNumInRow > result:
        result = minNumInRow

print(result)