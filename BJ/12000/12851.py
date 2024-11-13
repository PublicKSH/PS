from collections import deque

n,k = map(int, input().split())
dp = [-1 for _ in range(100002)]
dp[n] = 0
q = deque()
q.append(n)
result = 0

while q:
    if (n == k):
        result = 1
        break
    num = q.popleft()
    
    for nextNum in [num+1, num-1, num *2]:
        if 0 <= nextNum <= 100000:
            if dp[nextNum] == -1:
                dp[nextNum] = dp[num] + 1  
                q.append(nextNum)
                if nextNum == k:
                    result += 1
            elif dp[nextNum] == dp[num] + 1:
                q.append(nextNum)
                if nextNum == k:
                    result += 1
                continue

print(dp[k])
print(result)

# 5 -> 10 -> 9 -> 18 -> 17
# 5 -> 4 -> 8 -> 16 -> 17