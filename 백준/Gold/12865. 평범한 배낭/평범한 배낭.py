n, k = map(int, input().split())
list = [(0,0)]
d = [[0]*(k+1) for _ in range(n+1)]
for _ in range(n):
    w, v = map(int, input().split())
    list.append((w, v))

# dp[i][j] = max(dp[i-1][j], dp[i-1][j-w] + v)

for i in range(1, n+1):
    w = list[i][0]
    v = list[i][1]
    # j는 넣을 수 있는 무게
    for j in range(1, k+1):
        if j < w:
            d[i][j] = d[i-1][j]
        else:
            d[i][j] = max(d[i-1][j], d[i-1][j-w] + v)
        
print(d[n][k])