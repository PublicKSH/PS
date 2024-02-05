n, m = map(int, input().split())
kList = list(map(int, input().split()))

result = 0
for i in range(n):
    for j in range(i, n):
        if kList[i] != kList[j]:
           result += 1

print(result)