# 1. 조합
n, m = map(int, input().split())
arr = [i for i in range(1, n+1)]
result = [0] * (m+1)

def dfs(l, s):
    if l == m:
        # for i in range(m):
        #     print(result[i], end=' ')
        print(result)
    else:
        for i in range(s, n):
            result[l] = arr[i]
            dfs(l+1, i+1)

dfs(0,0)
print(result)
# 2. 모듈
