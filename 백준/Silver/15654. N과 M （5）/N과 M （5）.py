n, m = map(int, input().split())
arr = list(map(int, input().split()))
arr.sort()
visited = [False] * n

result = [0] * n
def dfs(count):
    if count == m:
       for i in range(m):
           print(result[i], end=' ')
       print()
       return
    else:
        for i in range(len(arr)):
            if not visited[i]:
                visited[i] = True
                result[count] = arr[i]
                dfs(count+1)
                visited[i] = False

dfs(0)