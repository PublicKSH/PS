n = int(input())
dp = [[0] * 10 for i in range(n)]

# 초기화
for i in range(10):
    dp[0][i] = 1
for i in range(n):
    dp[i][0] = 1

for i in range(1, n):
    for j in range(1, 10):
        dp[i][j] = dp[i][j-1] + dp[i-1][j]
print(sum(dp[n-1]) % 10007)