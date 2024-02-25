# todo: 다시풀기
n, k = map(int, input().split())
coinList = []
dp = [0] * (k+1)
dp[0] = 1
for i in range(n):
    coin = int(input())
    coinList.append(coin)
coinList.sort()

for coin in coinList:
    for j in range(coin, k+1):
        print(j, j-coin)
        dp[j] += dp[j-coin]

print(dp)