n = int(input())
listA = list(map(int, input().split()))
listB = list(map(int, input().split()))

listA.sort()
listB.sort(reverse=True)

result = 0

for i in range(n):
    result += listA[i] * listB[i]

print(result)