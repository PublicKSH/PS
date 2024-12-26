import sys
input = sys.stdin.readline

dp = [0 for _ in range(11)]
dp[1] = 1 # 1
dp[2] = 2 # 11, 2
dp[3] = 4 # 111, 12, 21, 3
dp[4] = 7 # 1111, 112, 121, 211, 22, 13, 31
# dp[n] = dp[n-1] + dp[n-2] + dp[n-3]
for k in range(4, 11):
    dp[k] = dp[k-1] + dp[k-2] + dp[k-3]
n = int(input())
for i in range(n):
    number = int(input())
    print(dp[number])