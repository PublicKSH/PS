n, k = map(int, input().split())
coinList = []
for i in range(n):
    coinList.append(int(input()))
dp = [0 for _ in range(k+1)]
# coin 만 써서 만드는 경우의 수
dp[0] = 1
coinList.sort()
for coin in coinList:
    for i in range(coin, k+1):
        dp[i] = dp[i-coin] + dp[i]

print(dp[k])