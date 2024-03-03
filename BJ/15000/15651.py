# 1. 중복 순열
n, m = map(int, input().split())
arr = [0] * (n + 1)
def dfs(count):
    if count == m:
        for i in range(m):
            print(arr[i], end=' ')
        print()
    else:
        for i in range(1, n+1):
            arr[count] = i
            dfs(count+1)

dfs(0)
