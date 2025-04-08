n = int(input())
packArr = list(map(int, input().split()))
dp = [0] * n
for i in range(n):
    dp[i] = packArr[0] * (i+1)
for i in range(1, len(packArr)):
    dp[i] = max(packArr[i], dp[i])
    for j in range(i+1, n):
        dp[j] = max(dp[j], dp[j-i-1] + dp[i])

print(dp[n-1])