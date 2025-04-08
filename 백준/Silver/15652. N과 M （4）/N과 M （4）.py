# todo: 다시 풀고 정리하기 (dfs를 활용한 순열,조합)
# 1. dfs
n, m = map(int, input().split())
arr = [i for i in range(1, n+1)]
result = [0] * (m+1)

def dfs(cnt, s):
    if cnt == m:
        for i in range(m):
            print(result[i], end=' ')
        print()
    else:
        for i in range(s, n):
            result[cnt] = arr[i]
            dfs(cnt+1, i)

dfs(0,0)
# 2. 모듈