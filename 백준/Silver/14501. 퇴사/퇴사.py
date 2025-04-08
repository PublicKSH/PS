# todo: 다시 풀기

n = int(input())
tList = [0] * (n+1)
pList = [0] * (n+1)
dp = [0] * (n+1)
maxValue = 0
for i in range(n):
    tList[i], pList[i] = map(int, input().split())

# 뒤에서 부터 dp 진행
# dp[i] = max(pList[i] + dp[tList[i] + i], maxValue)
for i in range(n-1, -1, -1):
    if tList[i] + i > n:
        dp[i] = maxValue
    else:
        dp[i] = max(pList[i] + dp[tList[i] + i], maxValue)
        maxValue = dp[i]
print(dp[0])