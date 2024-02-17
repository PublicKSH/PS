import sys
input = sys.stdin.readline
t = int(input())
result = 0
def dfs(number):
    global result
    if number == n:
        result += 1
        return

    for i in range(1,4):
        if (i + number <= n):
            dfs(number+i)

for i in range(t):
    n = int(input())
    result = 0
    dfs(0)
    print(result)

# dp 로도 풀 수 있다
# n을 1,2,3 더하기로 표현하는 점화식 dp[n] = dp[n-1] + dp[n-2] + dp[n-3]
    
    