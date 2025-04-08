import sys
input = sys.stdin.readline

T = int(input())
# dp[0][n] => 1,2 열까지는 직접 계산 해주고 이후에는 건너 뛰는 경우를 고려한 DP로 계산
for i in range(T):
    n = int(input())
    sticker =[[] for _ in range(2)]
    sticker[0] = list(map(int, input().split())) + [0]
    sticker[1] = list(map(int, input().split())) + [0]

    dp = [[0 for _ in range(n+1)] for _ in range(2)]
    
    dp[0][0] = sticker[0][0]
    dp[1][0] = sticker[1][0]
    if(n==1):
       print(max(dp[0][n-1],dp[1][n-1]))
       continue

    dp[0][1] = sticker[0][1] + sticker[1][0]
    dp[1][1] = sticker[1][1] + sticker[0][0]
    if(n==2):
       print(max(dp[0][n-1],dp[1][n-1]))
       continue
    
    for i in range(2,n):
        dp[0][i] = max(dp[1][i-1],dp[1][i-2]) + sticker[0][i]
        dp[1][i] = max(dp[0][i-1],dp[0][i-2]) + sticker[1][i]

    print(max(dp[0][n-1],dp[1][n-1]))
    