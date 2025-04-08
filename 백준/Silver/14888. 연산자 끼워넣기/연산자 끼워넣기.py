import sys
input = sys.stdin.readline
n = int(input())
numList = list(map(int, input().split()))
add, sub, mul, div = map(int, input().split())
minResult = 2e9
maxResult = -2e9

def dfs(i, now):
    global maxResult, minResult, add, sub, mul, div
    if i == n:
        if minResult > now:
            minResult = now
        if maxResult < now:
            maxResult = now
    if add > 0:
        add -= 1
        dfs(i+1, now + numList[i])
        add += 1
    if sub > 0:
        sub -= 1
        dfs(i+1, now - numList[i])
        sub += 1
    if mul > 0:
        mul -= 1
        dfs(i+1, now * numList[i])
        mul += 1
    if div > 0:
        div -= 1
        dfs(i+1, int(now / numList[i]))
        div += 1
dfs(1, numList[0])

print(maxResult)
print(minResult)