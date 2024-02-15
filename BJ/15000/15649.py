# 1. dfs
n, m = map(int, input().split())
arr = [0] * (n + 1)
visited = [False] * (n + 1)
def dfs(count):
    if count == m:
        for i in range(m):
            print(arr[i], end=' ')
        print()
    else:
        for i in range(1, n+1):
            if not visited[i] :
                visited[i] = True
                arr[count] = i
                dfs(count+1)
                visited[i] = False

dfs(0)
# 2. 모듈