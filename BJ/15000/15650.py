# todo: 다시 풀고 정리하기 (dfs를 활용한 순열,조합)
# 1. dfs
n, m = map(int, input().split())
arr = [i for i in range(1, n+1)]
resultArr = [0] * (m+1)

def dfs(l, s):
    if l == m:
        for i in range(m):
            print(resultArr[i], end=' ')
        print()
    else:
        for i in range(s, n):
            resultArr[l] = arr[i]
            dfs(l+1, i+1)

dfs(0,0)
# 2. 모듈
