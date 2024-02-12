n = int(input())
dp = []

for i in range(n) :
  dp.append(list(map(int, input().split())))
print(dp)

# dp 진행

for i in range(1, n):
    m = len(dp[i])
    for j in range(m):
        if j == 0:
            dp[i][j] = dp[i][j] + dp[i-1][j] 
        elif j == m-1:
            dp[i][j] = dp[i][j] + dp[i-1][j-1]
        else: 
            dp[i][j] = dp[i][j] + max(dp[i-1][j], dp[i-1][j-1])

print(dp) 
# print(dp)

# 5
# 7
# 3 8
# 8 1 0 
# 2 7 4 4 
# 4 5 2 6 5