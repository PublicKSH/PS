n = int(input())
arr = []
for i in range(n):
    arr.append(list(map(int, input().split())))
visited = [False] * n

result = 1e9
def dfs(count, s):
    global result
    if count == int(n//2):
        ATeamScore = 0
        BTeamScore = 0
        for i in range(n):
            for j in range(n):
                if visited[j] and visited[i]:
                    ATeamScore += arr[i][j] 
                if not visited[j] and not visited[i]:
                    BTeamScore += arr[i][j] 

        result = min(result, abs(ATeamScore - BTeamScore))
    else:
        for i in range(s, n):
            visited[i] = True
            dfs(count+1, i+1)
            visited[i] = False

dfs(0, 0)
print(result)